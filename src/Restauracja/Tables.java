package Restauracja;

import java.util.ArrayList;

public class Tables {

    private final ArrayList <Table> tableArrayList;
    private final Table table1;
    private final Table table2;
    private final Table table3;
    private final Table table4;

    private final String[][] tables = {
            {"╔══════════════", "═══|▓▓▓▓|═══", "══════════════╗"},
            {"║              ", "   |▓▓▓▓|   ", "              ║"},
            {"║    --■■--■■--", "   |▓▓▓▓|   ", "--■■--■■--    ║   .----------------------------------."},
            {"║ #1 ██████████", "   |▓▓▓▓|   ", "██████████ #2 ║   |      Witamy w Cluckin' Bell!     |"},
            {"║    --■■--■■--", "   |▓▓▓▓|   ", "--■■--■■--    ║   | Wybierz jeden spośród wszystkich |"},
            {"║              ", "   |▓▓▓▓|   ", "              ║   |       dostepnych stolikow.       |"},
            {"║              ", "   |▓▓▓▓|   ", "              ║   '----------------------------------'"},
            {"║              ", "   |▓▓▓▓|   ", "              ║"},
            {"║    --■■--■■--", "   |▓▓▓▓|   ", "--■■--■■--    ║"},
            {"║ #3 ██████████", "   |▓▓▓▓|   ", "██████████ #4 ║"},
            {"║    --■■--■■--", "   |▓▓▓▓|   ", "--■■--■■--    ║"},
            {"║             ", "    |▓▓▓▓|   ", "              ║"},
            {"╚══════════════", "═══|▓▓▓▓|═══", "══════════════╝"},
    };

    public Tables() {
        this.tableArrayList = new ArrayList<>();
        this.table1 = new Table(1);
        tableArrayList.add(table1);
        this.table2 = new Table(2);
        tableArrayList.add(table2);
        this.table3 = new Table(3);
        tableArrayList.add(table3);
        this.table4 = new Table(4);
        tableArrayList.add(table4);

        setTableAvalible(1);
        setTableAvalible(2);
        setTableAvalible(3);
        setTableAvalible(4);
    }

    public Table getTable1() {
        return table1;
    }

    public Table getTable2() {
        return table2;
    }

    public Table getTable3() {
        return table3;
    }

    public Table getTable4() {
        return table4;
    }

    public void printTables() {
        for (int i = 0; i < tables.length; i++) {

            for (int j = 0; j < tables[i].length; j++) {
                System.out.print(tables[i][j]);
            }
            System.out.println();
        }
    }

    public void setTableNOt(int tableNOt) {

        switch (tableNOt) {
            case 1:
                table1.setAvalible(false);
                tables[1][0] = "║      Zajęty  ";
                break;
            case 2:
                table2.setAvalible(false);
                tables[1][2] = "  Zajęty      ║";
                break;
            case 3:
                table3.setAvalible(false);
                tables[7][0] = "║      Zajęty  ";
                break;
            case 4:
                table4.setAvalible(false);
                tables[7][2] = "  Zajęty      ║";
                break;
            default:
                System.out.println("Gowno");
        }
    }
    public void setTableAvalible(int tableAvalible) {

        switch (tableAvalible) {
            case 1:
                table1.setAvalible(true);
                tables[1][0] = "║     Dostępny ";
                break;
            case 2:
                table2.setAvalible(true);
                tables[1][2] = " Dostępny     ║";
                break;
            case 3:
                table3.setAvalible(true);
                tables[7][0] = "║     Dostępny ";
                break;
            case 4:
                table4.setAvalible(true);
                tables[7][2] = " Dostępny     ║";
                break;
            default:
                System.out.println("Podaj lol");
        }
    }




    public static class Table {


        private boolean avalible;
        private int name;


        public Table(int name) {
            this.name = name;
        }


        public int getName() {
            return name;
        }
        public boolean isAvalible() {
            return avalible;
        }

        public void setAvalible(boolean avalible) {
            this.avalible = avalible;
        }
    }
}
