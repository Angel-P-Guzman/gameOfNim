public class Board {
    private static int pieces;

    public static void populate() {
        pieces = 10 + (int) (Math.random() * 50);
    }

    public static int getNumPieces() {
        return pieces;
    }

    public static void removePieces(int numPieces) {
        pieces -= numPieces;
    }
}
