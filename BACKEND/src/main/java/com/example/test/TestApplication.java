package com.example.test;

import com.example.test.model.Car;
import com.example.test.model.User;
import com.example.test.repository.CarRepository;
import com.example.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		initCarData();
		initUserData();
		initCommentData();
	}

	private void initCommentData() {

	}

	private void initUserData() {
		User user = new User();
		user.setUserName("test");
		user.setPassWord("test");
		user.setEnabled(true);
		user.setCreated(Instant.now());
		userRepository.save(user);

		User user1 = new User();
		user1.setUserName("test");
		user1.setPassWord("test");
		user1.setEnabled(true);
		user1.setCreated(Instant.now());
		userRepository.save(user1);
	}

	private void initCarData() {
		String carUrl [] = {
				"https://www.sport.kokcar.com/wp-content/uploads/2022/01/Car-market-2021-the-best-selling-models-in-Europe-768x430.jpg",
				"https://www.byri.net/wp-content/uploads/2021/11/The-Peugeot-2008-best-car-sales-in-Europe-in-October-690x375.jpg",
				"https://seriesmotor.com/wp-content/uploads/2022/02/Best-selling-cars-in-Europe-2021.jpg",
				"https://seriesmotor.com/wp-content/uploads/2022/02/1645709585_303_Best-selling-cars-in-Europe-2021.jpg",
				"https://seriesmotor.com/wp-content/uploads/2022/02/1645709590_803_Best-selling-cars-in-Europe-2021.jpg",
				"https://seriesmotor.com/wp-content/uploads/2022/02/1645709590_216_Best-selling-cars-in-Europe-2021.jpg",
				"https://seriesmotor.com/wp-content/uploads/2022/02/1645709589_58_Best-selling-cars-in-Europe-2021.jpg",
				"https://seriesmotor.com/wp-content/uploads/2022/02/1645709587_450_Best-selling-cars-in-Europe-2021.jpg",
				"https://cars.usnews.com/pics/size/776x517/images/Auto/izmo/i159423547/2020_honda_fit_angularfront.jpg",
				"https://seriesmotor.com/wp-content/uploads/2022/02/1645709586_541_Best-selling-cars-in-Europe-2021.jpg"
		};
		String carPrice [] = { " 10000000","20000000 " , " 30000000" , "400000000" ,"50000000","56000000","90000000","200000000","700000000","786900000000"};
		for (int i = 0; i < carPrice.length; i++) {
			Car car = new Car("car"+String.valueOf(i),carUrl[i],carPrice[i]+" Ar");
			carRepository.save(car);
		}
	}

}
