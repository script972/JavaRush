package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {

    private static final int FIELD_WIDTH = 4;

    private Tile [][] gameTiles;

    private Stack<Tile[][]> previousStates;
    private Stack<Integer> previousScores;

    private boolean isSaveNeeded = true;

     int score;
     int maxTile;

    public Model() {
        score=0;
        maxTile=2;
        gameTiles=new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                gameTiles[i][j]=new Tile();
            }
        }
        resetGameTiles();
        this.previousStates = new Stack<Tile[][]>();
        this.previousScores=new Stack<Integer>();
    }

    // вовзращает лист пустых клеток
    private List<Tile> getEmptyTiles() {
        List<Tile> result = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) result.add(gameTiles[i][j]);
            }
        }
        return result;
    }

    // добавляет рандомно клетку 2 или 4 (соотношение 1 к 9)
    private void addTile() {

        List<Tile> list = getEmptyTiles();
        if (list != null && list.size() != 0) {
            list.get((int) (list.size() * Math.random())).setValue(Math.random() < 0.9 ? 2 : 4);
        }
    }

    // сброс всех клеток
    void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                this.gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    // ряд {4, 2, 0, 4} становится рядом {4, 2, 4, 0}
    private boolean compressTiles(Tile[] tiles){
        boolean isChanged = false;
        Tile temp;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tiles[j].getValue() == 0 && tiles[j + 1].getValue() != 0) {
                    temp = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = temp;
                    isChanged = true;
                }
            }
        }
        return isChanged;
    }

    /**
     *
     * ряд {4, 4, 2, 0} становится рядом {8, 2, 0, 0}.
     Обрати внимание, что ряд {4, 4, 4, 4} превратится в {8, 8, 0, 0}, а {4, 4, 4, 0} в {8, 4, 0, 0}.
     */
    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int j = 0; j < 3; j++) {
            if (tiles[j].getValue() != 0 && tiles[j].getValue() == tiles[j + 1].getValue()) {
                tiles[j].setValue(tiles[j].getValue() * 2);
                tiles[j + 1].setValue(0);
                if (tiles[j].getValue() > maxTile) maxTile = tiles[j].getValue();
                score += tiles[j].getValue();
                isChanged = true;

            }
        }

        if (isChanged) {
            Tile temp;
            for (int j = 0; j < 3; j++) {
                if (tiles[j].getValue() == 0 && tiles[j + 1].getValue() != 0) {
                    temp = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = temp;
                }
            }
        }

        return isChanged;
    }



    // поворот матрицы на 90 градусов против часовой стрелки
    void rotate() {
        int len = FIELD_WIDTH;
        for (int i = 0; i < len / 2; i++) // border -> center
        {
            for (int j = i; j < len - 1 - i; j++) // left -> right
            {

                Tile tmp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[j][len - 1 - i];
                gameTiles[j][len - 1 - i] = gameTiles[len - 1 - i][len - 1 - j];
                gameTiles[len - 1 - i][len - 1 - j] = gameTiles[len - 1 - j][i];
                gameTiles[len - 1 - j][i] = tmp;
            }
        }
    }

    void saveState(Tile[][] field) {
        Tile[][] fieldToSave = new Tile[field.length][field[0].length];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                fieldToSave[i][j] = new Tile(field[i][j].getValue());
            }
        }
        previousStates.push(fieldToSave);
        int scoreToSave = score;
        previousScores.push(scoreToSave);
        isSaveNeeded = false;
    }

    void left(){
        if (isSaveNeeded) saveState(this.gameTiles);
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }
        if (isChanged) {
            addTile();
            isSaveNeeded = true;
        }
    }

    void up() {
        saveState(this.gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    void right() {
        saveState(this.gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    void down() {
        saveState(this.gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    // проверка возможности хода
    public boolean canMove() {
        if (!getEmptyTiles().isEmpty())
            return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                    return true;
            }
        }
        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 1; i < gameTiles.length; i++) {
                if (gameTiles[i][j].value == gameTiles[i - 1][j].value)
                    return true;
            }
        }
        return false;
    }

    // откат на один ход назад
    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            this.score = previousScores.pop();
            this.gameTiles = previousStates.pop();
        }
    }

    // делает ход в случайном направлении
    public void randomMove() {
        switch (((int) (Math.random() * 100)) % 4) {
            case 0:
                left();
                break;
            case 1:
                up();
                break;
            case 2:
                right();
                break;
            case 3:
                down();
                break;
        }
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue(4, Collections.reverseOrder());
        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::right));
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::down));
        Move move = queue.peek().getMove();
        move.move();
    }

    private boolean hasBoardChanged() {
        boolean result = false;
        int sumNow = 0;
        int sumPrevious = 0;
        Tile[][] tmp = previousStates.peek();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                sumNow += gameTiles[i][j].getValue();
                sumPrevious += tmp[i][j].getValue();
            }
        }
        return sumNow != sumPrevious;
    }

    private MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();
        if (hasBoardChanged()) moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        else moveEfficiency = new MoveEfficiency(-1, 0, move);
        rollback();

        return moveEfficiency;
    }





}
