package semester2.homework.hw04;

    abstract class ConnectPlayer {
        int player;
        int getID() {
            return 0;
        }
    }

    class C4HumanPlayer extends ConnectPlayer {
        C4HumanPlayer (int ID) {
            this.player = ID;
        }

        @Override
        int getID () {
            return this.player;
        }
    }

    class C4RandomAIPlayer extends ConnectPlayer {
        C4RandomAIPlayer (int ID) {
            this.player = ID;
        }

        @Override
        int getID () {
            return this.player;
        }
        int getNextStep(Connect4Grid2DArray game) {
            boolean isValid = false;
            int temp = game.lastestColumn;
            while (!isValid) {
                temp = (int) (Math.random() * 7);
                if (game.isValidColumn(temp) && !game.isColumnFull(temp)) {
                    isValid = true;
                }
            }
            return temp;
        }
    }
