package com.ieugene.algorithmdemo;

import java.util.ArrayList;
import java.util.List;

public class AStartSearch {
    private static final int[][] MAZE = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
    };

    public Grid aStartSearch(Grid start, Grid end) {
        ArrayList<Grid> openList = new ArrayList<>();
        ArrayList<Grid> closeList = new ArrayList<>();
        openList.add(start);
        while (openList.size() > 0) {
            Grid currentGrid = findMinGrid(openList);
            openList.remove(currentGrid);
            closeList.add(currentGrid);
            List<Grid> neighbors = findNeighbors(currentGrid, openList, closeList);
            for (Grid grid : neighbors) {
                if (!openList.contains(grid)) {
                    grid.initGrid(currentGrid, end);
                    openList.add(grid);
                }
            }
            for (Grid grid : openList) {
                if ((grid.x == end.x) && grid.y == end.y) {
                    return grid;
                }
            }
        }
        return null;
    }

    private Grid findMinGrid(ArrayList<Grid> openList) {
        Grid tempGrid = openList.get(0);
        for (Grid grid : openList) {
            if (grid.f < tempGrid.f) {
                tempGrid = grid;
            }
        }
        return tempGrid;
    }

    private ArrayList<Grid> findNeighbors(Grid grid, List<Grid> openList, List<Grid> closeList) {
        ArrayList<Grid> gridList = new ArrayList<>();
        if (isValidGrid(grid.x, grid.y - 1, openList, closeList)) {
            gridList.add(new Grid(grid.x, grid.y - 1));
        }
        if (isValidGrid(grid.x, grid.y + 1, openList, closeList)) {
            gridList.add(new Grid(grid.x, grid.y + 1));
        }
        if (isValidGrid(grid.x - 1, grid.y, openList, closeList)) {
            gridList.add(new Grid(grid.x - 1, grid.y));
        }
        if (isValidGrid(grid.x + 1, grid.y, openList, closeList)) {
            gridList.add(new Grid(grid.x + 1, grid.y));
        }
        return gridList;
    }

    private boolean isValidGrid(int x, int y, List<Grid> openList, List<Grid> closeList) {
        if (x < 0 || x >= MAZE.length || y < 0 || y >= MAZE[0].length) {
            return false;
        }
        //障碍物
        if (MAZE[x][y] == 1) {
            return false;
        }
        if (containGrid(openList, x, y)) {
            return false;
        }
        if (containGrid(closeList, x, y)) {
            return false;
        }
        return true;
    }

    private boolean containGrid(List<Grid> grids, int x, int y) {
        for (Grid n : grids) {
            if ((n.x == x) && (n.y == y)) {
                return true;
            }
        }
        return false;
    }

    private static class Grid {
        int x, y;
        int f, g, h;
        Grid parent;

        public Grid(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void initGrid(Grid parent, Grid end) {
            this.parent = parent;
            if (parent != null) {
                this.g = parent.g + 1;
            } else {
                this.g = 1;
            }
            this.h = Math.abs(this.x - end.x) + Math.abs(this.y - end.y);
            this.f = this.g + this.h;
        }
    }

    public static void main(String[] args) {
        Grid startGrid = new Grid(2, 1);
        Grid endGrid = new Grid(2, 5);
        AStartSearch startSearch = new AStartSearch();
        Grid result = startSearch.aStartSearch(startGrid, endGrid);
        ArrayList<Grid> path = new ArrayList<>();
        while (result != null) {
            path.add(new Grid(result.x, result.y));
            result = result.parent;
        }
        for (int i = 0; i < MAZE.length; i++) {
            for (int j = 0; j < MAZE[0].length; j++) {
                if (startSearch.containGrid(path, i, j)) {
                    System.out.print("*, ");
                } else {
                    System.out.print(MAZE[i][j] + ", ");
                }
            }
            System.out.println();
        }
    }
}
