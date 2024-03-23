package com.example.pegsandjokers;

public class Game {
    private Board board;
    private Player[] players;
    private Deck deck;

    public Game(Player[] players){
        this.board = new Board(players.length);
        this.players = players;
        this.deck = new Deck();
    }

    public void play(){
        while(!isWinner()){
            for (Player p: this.players){
                takeTurn(p);
            }
        }
    }

    public void takeTurn(Player player) {
        Card c = getCardFromInput();
        Peg p = getPegFromInput();
        if (c.getValue().equals(Value.TWO)) {
            Peg p2 = getPegFromInput();
            //TODO
        } else if (c.getValue().equals(Value.JOKER)) {
            //TODO
        } else if (c.getValue().equals(Value.SEVEN) || c.getValue().equals(Value.NINE)) {
            //TODO
        } else {
            move(p, c);
        }

    }

    public Card getCardFromInput(){
        Card c = null;
        //TODO
        return c;
    }

    public Peg getPegFromInput(){
        Peg p = new Peg();
        //TODO
        return p;
    }

    public boolean movePeg(Peg peg, int spaces, boolean forward){
        CircularLinkedList<Hole> loop = this.board.getLoop();
        Node<Hole> node = loop.get(peg.getHole());
        Player p = peg.getPlayer();
        int count = 0;
        while (count < spaces) {
            if (forward) {
                node = node.getNext();
            } else {
                node = node.getPrevious();
            }

            Peg obstacle = node.getData().getPeg();
            if (obstacle != null && obstacle.getPlayer().equals(p)){
                return false;
            }
            count++;
        }
        return addPegToHole(peg, node.getData());
    }

    public boolean testMovePeg(Peg peg, int spaces, boolean forward){
        CircularLinkedList<Hole> loop = this.board.getLoop();
        Node<Hole> node = loop.get(peg.getHole());
        Player p = peg.getPlayer();
        int count = 0;
        while (count < spaces) {
            if (forward) {
                node = node.getNext();
            } else {
                node = node.getPrevious();
            }

            Peg obstacle = node.getData().getPeg();
            if (obstacle != null && obstacle.getPlayer().equals(p)){
                return false;
            }
            count++;
        }
        return testAddPegToHole(peg, node.getData());
    }

    public boolean move(Peg peg, Card card){
        Value value = card.getValue();
        return switch (value) {
            case ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, NINE, TEN, JACK, QUEEN, KING -> {
                movePeg(peg, value.ordinal() + 1, true);
                yield true;
            }
            case EIGHT -> {
                movePeg(peg, value.ordinal() + 1, false);
                yield true;
            }
            default -> false;
        };
    }

    /**
     * Handles a split move where two pegs are moved, with the sum of the spaces moved equal to the sum
     * of the card's value.
     *
     * @param peg1 - The first peg to be moved
     * @param peg2 - The second peg to be moved
     * @param card - The card that is being played for a split (Which is a 7 or a 9)
     * @param spacesForward - How many spaces the first peg should be moved forward.
     * @return - Whether the move was successful.
     */
    public boolean splitMove(Peg peg1, Peg peg2, Card card, int spacesForward){
        //Get value of the card (either a SEVEN or a NINE).
        Value value = card.getValue();
        //Check if the first peg can be moved as desired.
        boolean test = testMovePeg(peg1, spacesForward, true);
        //Check if the second peg can also be moved as desired.
        test = test && testMovePeg(peg2, value.ordinal() + 1 - spacesForward, value.equals(Value.SEVEN));
        //If both can be, move them as desired, move successful.
        if (test){
            //Move the first peg forward the provided spaces.
            movePeg(peg1, spacesForward, true);
            //Move the second peg the remaining spaces. Forward if a 7, backward if a 9.
            movePeg(peg2, value.ordinal() + 1 - spacesForward, value.equals(Value.SEVEN));
            return true;
        }
        //Move is not successful.
        return false;
    }

    /**
     * Determines if there is a winner in the game by checking if any pair of partner players has all their
     * pieces in their respective heavens.
     *
     * @return - Whether there is a winner.
     */
    public boolean isWinner(){
        //Loop through the first half of the players
        for (int i = 0; i < this.players.length / 2; i++){
            boolean winner = true;
            Player p = this.players[i];
            //Loop through each of the player's pegs.
            for (Peg peg : p.getPegs()){
                //If any peg isn't in heaven, set winner to false.
                if (!peg.getInHeaven()) {
                    winner = false;
                    break;
                }
            }

            //Loop through each of the player's partner's pegs.
            for (Peg peg: p.getPartner().getPegs()){
                //If any peg isn't in heaven, set winner to false.
                if (!peg.getInHeaven()) {
                    winner = false;
                    break;
                }
            }

            //If winner is still true, there is a winner.
            if (winner){
                return true;
            }
        }
        //There is no winner.
        return false;
    }

    /**
     * Handles swapping of two pieces on the board.
     * Updates the peg attributes of both holes to be the other peg.
     * Updates the hole attributes of both pegs to be the other hole.
     *
     * @param peg1 - one peg to be swapped.
     * @param peg2 - the other peg to be swapped.
     */
    public void swap(Peg peg1, Peg peg2){
        //Get the two holes
        Hole a = peg1.getHole();
        Hole b = peg2.getHole();

        //Assign the pegs to their new holes.
        a.setPeg(peg2);
        b.setPeg(peg1);

        //Assign the holes to their new pegs.
        peg1.setHole(b);
        peg2.setHole(a);
    }

    /**
     * Handles when one piece moves onto the hole that is being occupied by another piece, known as a "kill" in the game.
     * If the two pegs are partners, the peg that is moved onto will be sent to that player's "heaven's gate".
     * If the two pegs aren't friendly, the peg that is moved onto will be sent to that player's "home".
     *
     * @param a - the peg that is moving onto the occupied hole.
     * @param b - the peg this is occupying the hole.
     * @return - Whether the move was successful.
     */
    public boolean kill(Peg a, Peg b){
        //Get the hole peg b is occupying.
        Hole hole = b.getHole();
        //If the pegs are two partner pieces.
        if (a.getPlayer().getPartner().equals(b.getPlayer())){
            //Call sendToHeavensGate on b first, if that is successful, call addPegToHole on peg a and the hole.
            return sendToHeavensGate(b) && addPegToHole(a, hole);
        } else {
            //If the pegs aren't partner pieces, remove the peg from the hole.
            hole.removePeg();
            //Send the peg to its home.
            b.sendHome();
            //call addPegToHole on peg a and the hole.
            return this.addPegToHole(a, hole);
        }
    }

    /**
     * Handles sending a piece to the player's "heaven's gate".
     *
     * @param p - the peg that is being moved.
     * @return - Whether the move was successful.
     */
    public boolean sendToHeavensGate(Peg p){
        //Get the player and their heaven's gate.
        Player player = p.getPlayer();
        Hole heavensGate = player.getHeavensGate();
        //Call the addPegToHole function on the peg and hole.
        return addPegToHole(p, heavensGate);
    }

    /**
     * Handles adding a peg to a specified hole.
     * If the hole is unoccupied, the peg is removed from its previous hole and added to the hole.
     * If the hole is occupied by a peg of the same color, the move is unsuccessful.
     * If the hole is occupied by a peg that isn't of the same color, calls the kill function.
     *
     * @param p - The peg that is being added to the hole.
     * @param h - The hole the peg is being added to.
     * @return - Whether the move was successful.
     */
    public boolean addPegToHole(Peg p, Hole h){
        Player player = p.getPlayer();

        //If the hole is empty, do the following:
        if (h.getPeg() == null){
            //Remove the peg from previous hole
            p.getHole().removePeg();
            //Add the peg to the hole
            h.setPeg(p);
            //Assign the new hole to the peg.
            p.setHole(h);
            //Successful turn
            return true;
        } else if (h.getPeg().getPlayer().equals(player)){
            //If the hole has a peg of the same color, unsuccessful turn
            return false;
        } else {
            //If the hole is occupied by a different color, call kill function.
            return kill(p, h.getPeg());
        }
    }

    /**
     * A test version of addPegToHole() for moves that have concurrent moving pieces, all of which need to be checked
     * before any attributes are updated.
     * If the hole is unoccupied, the peg is removed from its previous hole and added to the hole.
     * If the hole is occupied by a peg of the same color, the move is unsuccessful.
     * If the hole is occupied by a peg that isn't of the same color, calls the kill function.
     *
     * @param p - The peg that is being added to the hole.
     * @param h - The hole the peg is being added to.
     * @return - Whether the move was successful.
     */
    public boolean testAddPegToHole(Peg p, Hole h){
        Player player = p.getPlayer();

        //If the hole is empty, do the following:
        if (h.getPeg() == null){
            //Successful turn
            return true;
        } else if (h.getPeg().getPlayer().equals(player)){
            //If the hole has a peg of the same color, unsuccessful turn
            return false;
        } else {
            //If the hole is occupied by a different color, call kill function.
            return kill(p, h.getPeg());
        }
    }

    /**
     * A test version of kill() for moves that have concurrent moving pieces, all of which need to be checked
     * before any attributes are updated.
     * If the two pegs are partners, the peg that is moved onto will be sent to that player's "heaven's gate".
     * If the two pegs aren't friendly, the peg that is moved onto will be sent to that player's "home".
     *
     * @param a - the peg that is moving onto the occupied hole.
     * @param b - the peg this is occupying the hole.
     * @return - Whether the move was successful.
     */
    public boolean testKill(Peg a, Peg b){
        //Get the hole peg b is occupying.
        Hole hole = b.getHole();
        //If the pegs are two partner pieces.
        if (a.getPlayer().getPartner().equals(b.getPlayer())){
            //Call sendToHeavensGate on b first, if that is successful, call addPegToHole on peg a and the hole.
            return testSendToHeavensGate(b) && testAddPegToHole(a, hole);
        } else {
            //Sending an opponent to their home will always succeed.
            return true;
        }
    }

    /**
     * A test version of sendToHeavensGate() for moves that have concurrent moving pieces, all of which need to be checked
     * before any attributes are updated.
     *
     * @param p - the peg that is being moved.
     * @return - Whether the move was successful.
     */
    public boolean testSendToHeavensGate(Peg p){
        //Get the player and their heaven's gate.
        Player player = p.getPlayer();
        Hole heavensGate = player.getHeavensGate();
        //Call the addPegToHole function on the peg and hole.
        return testAddPegToHole(p, heavensGate);
    }



    /**
     * Handles removing a peg from the player's home.
     *
     * @param p - the peg to get out of home.
     * @return - Whether the move was successful.
     */
    public boolean getOut(Peg p){
        //Get the player and their homeStep
        Player player = p.getPlayer();
        Hole homeStep = player.getHomeStep();
        //Call the addPegToHole function on the piece and the hole.
        if (addPegToHole(p, homeStep)){
            //If successful, remove peg from home, return true.
            p.removeFromHome();
            return true;
        }
        //If unsuccessful, return false.
        return false;
    }
}
