package services;

public class ArcSolver {
	
	public double[] solve(double x1, double y1, double r1, double x2, double y2, double r2) {
		double[] answer = {-1, -1};
		double angle = 0.0;
		double step = 6.28318530718 / (r1 * 8);
		double x = x1 + (r1 * Math.cos(-step));
		double y = y1 + (r1 * Math.sin(-step));
		double xi = x1 + r1;
		double yi = y1;
		double dist = Math.sqrt(((x - x2) * (x - x2)) + ((y - y2) * (y - y2)));
		double disti = Math.sqrt(((xi - x2) * (xi - x2)) + ((yi - y2) * (yi - y2)));
		int flag = 0;
		while(angle < (6.28318530718)) {
			if (((dist > r2) && (disti < r2)) || ((disti > r2) && (dist < r2)) || (disti == r2)) {
				if(flag == 0) {
					answer[0] = angle;
					flag = 1;
				}
				else {
					answer[1] = angle;
					break;
				}
			}
			x = xi;
			y = yi;
			dist = disti;
			angle = angle + step;
			xi = x1 + (r1 * Math.cos(angle));
			yi = y1 + (r1 * Math.sin(angle));
			disti = Math.sqrt(((xi - x2) * (xi - x2)) + ((yi - y2) * (yi - y2)));
		}
		if(answer[1] == -1)
			answer[1] = answer[0];
		return answer;
	}

}