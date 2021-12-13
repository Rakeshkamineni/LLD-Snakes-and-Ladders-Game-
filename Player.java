class Player {
    private String name;
    private int position = 0;

    Player(String name) {
        this.name = name;

    }

    public String getPlayerName() {
        return name;
    }

    public int getPlayerPosition() {
        return position;
    }

    public void setPlayerPosition(int newposition) {
        this.position = newposition;
    }
}