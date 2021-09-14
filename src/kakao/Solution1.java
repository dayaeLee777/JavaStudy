package kakao;

public class Solution1 {

	public static void main(String[] args) {
		Point p3 = new Point(124, 4);
		
		Point hit = p3.getHitPoint(0);
		System.out.println(hit.x + " + " + hit.y);
		
	}

	static Point[] halllist = {new Point(127, 0)};
	static Point[] balllist = {new Point(127, 0)};
	static boolean[] ballselected;
	static double R=5;

	private static class Point {
		double x;
		double y;

		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}

		double getDistance(Point target) {
			double distance = Math.sqrt(Math.pow(target.x - this.x, 2) + Math.pow(target.y - this.y, 2));
			return distance;
		}

		double getRadian(Point target) {
			double radian = Math.atan2(target.y - this.y, target.x - this.x);

			return radian;
		}

		double getAngle(Point target) {
			double angle = Math.toDegrees(Math.atan2(target.y - this.y, target.x - this.x));
			if (angle < 0)
				angle += 360;
			return angle;
		}

		// 히트 포인트 구하기
		Point getHitPoint(int hit) {
//			int h = getTargetHall(target);
//			Point targetHall = halllist[h];
			Point targetHall = halllist[hit];
			
			double c = targetHall.getDistance(this);
			// 순서가 중요할듯
			double radian = targetHall.getRadian(this);
			
			
			double nx = targetHall.x + (c + R) * Math.cos(radian);
			double ny = targetHall.y + (c + R) * Math.sin(radian);

			Point Hit = new Point(nx, ny);

			return Hit;
		}

		// 타켓으로할 구멍찾기
		int getTargetHall(Point target) {
			double min = Double.MAX_VALUE;
			int res = 6;
			for (int i = 0; i < 6; i++) {
				double dist = target.getDistance(target);
				if (dist < min) {
					res = i;
				}
			}
			return res;
		}
		
		// 구멍까지의 거리 구하기
		double getHallDist(Point target) {
			double min = Double.MAX_VALUE;
			for (int i = 0; i < 6; i++) {
				double dist = target.getDistance(target);
				if (dist < min) {
					min = dist;
				}
			}
			return min;
		}
		
		// 공이 여러개일때 타켓볼 찾기
		int getTargetBall() {
			int ball=8;
			double min = Double.MAX_VALUE;
			for(int i=1;i<=3;i+=2) {
				if(!ballselected[i] && min < getHallDist(balllist[i])) {
					min = getHallDist(balllist[i]);
					ball = i;
				}
			}
			ballselected[ball] = true;
			
			return ball;
		}
	}

}
