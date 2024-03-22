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

    public boolean isWinner(){
        for (Player p : this.players){
            boolean winner = true;
            for (Peg peg : p.getPegs()){
                if (!peg.getInHeaven()) {
                    winner = false;
                    break;
                }
            }
            for (Peg peg: p.getPartner().getPegs()){
                if (!peg.getInHeaven()) {
                    winner = false;
                    break;
                }
            }
            if (winner){
                return true;
            }
        }
        return false;
    }

    public void movePeg(Peg peg, int spaces, boolean forward){
        //TODO
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

    public boolean splitMove(Peg peg1, Peg peg2, Card card, int spacesForward){
        Value value = card.getValue();
        if (spacesForward >= value.ordinal() + 1){
            return false;
        }

        movePeg(peg1, spacesForward, true);
        movePeg(peg2, value.ordinal() + 1 - spacesForward, value.equals(Value.SEVEN));
        return true;
    }

    public void swap(Peg peg1, Peg peg2){
        Hole temp = peg1.getHole();
        peg1.setHole(peg2.getHole());
        peg2.setHole(temp);
    }

    public void kill(Peg a, Peg b){
        if (a.getPlayer().getPartner().equals(b.getPlayer())){
            Hole temp = b.getHole();
            sendToHeavensGate(b);
            a.setHole(temp);
        } else {
            Hole temp = b.getHole();
            b.setInHome(true);
            a.setHole(temp);
        }
    }

    public void sendToHeavensGate(Peg p){
        p.getHole().setFilled(false);
        Player player = p.getPlayer();
        CircularLinkedList<Hole> loop = this.board.getLoop();


    }

    public boolean getOut(Card card){
        Value value = card.getValue();
        return switch (value) {
            case ACE, JACK, QUEEN, KING -> {
                //TODO
                yield true;
            }
            default -> false;
        };
    }
}
