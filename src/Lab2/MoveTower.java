package Lab2;

public class MoveTower {
	public static void moveTower(int disk, char source, char dest, char spare) {
		if (disk == 1) {
			System.out.println("Move disk 1 from " + source + " to " + dest);
			return;
		}
		moveTower(disk - 1, source, spare, dest);
		System.out.println("Move disk: " + disk + " from " + source + " to " + dest);
		moveTower(disk - 1, spare, dest, source);
	}

	public static void main(String[] args) {
		moveTower(5, 'A', 'C', 'B');
	}
}
