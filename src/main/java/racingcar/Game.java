package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
	private List<Car> carList = new ArrayList<>();
	private int executeCount = 0;
	private Random random = new Random();

	public Game(int carListSize) {
		makeCar(carListSize);
	}

	private void makeCar(int carListSize) {
		for (int i = 0; i < carListSize; i++) {
			carList.add(new Car());
		}
	}

	public List<Car> getCar() {
		return carList;
	}

	public int getExecuteCount() {
		return this.executeCount;
	}

	public void run(int executeCount) {
		ResultView resultView = new ResultView();
		resultView.printHead();
		this.executeCount = 0;

		for (int i = 0; i < executeCount; i++) {
			execute(resultView);
			this.executeCount++;
		}
	}

	private void execute(ResultView resultView) {
		for (Car car : carList) {
			moveOrStop(car);
			resultView.printPosition(car.getPosition());
		}
		resultView.printEmptyLine();

	}

	public void moveOrStop(Car car) {
		int randomNumber = random.nextInt(10);
		if (randomNumber >= 4) {
			car.move();
		}
	}

}
