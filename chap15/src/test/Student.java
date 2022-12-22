package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Std {
	int kor;
	int math;
	int eng;
	int sum = 0;
	double avg = 0.0;

	public Std(int kor, int math, int eng) {
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}

	@Override
	public String toString() {

		sum = kor + math + eng;
		avg = sum / 3;

		return "총점: " + sum + ", 평균: " + avg + "\n끝";
	}

}

public class Student {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("이름: ");
			String name = scan.next();
			if (name.equals("q"))
				break;
			System.out.print("국어: ");
			int kor = scan.nextInt();
			System.out.print("수학: ");
			int math = scan.nextInt();
			System.out.print("영어: ");
			int eng = scan.nextInt();
			Std std = new Std(kor, math, eng);
			System.out.println(std.toString());

			FileOutputStream fos = new FileOutputStream("scores.txt", true);
			PrintWriter pw = new PrintWriter(fos);

			pw.println("이름: " + name + " 국어: " + kor + "수학: " + math + " 영어: " + eng + " 총점: " + std.sum + " 평균:"
					+ std.avg);

			pw.close();
			fos.close();

		}

	}

}
