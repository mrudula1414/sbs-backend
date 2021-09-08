package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.CompanyRepository;
import com.example.demo.models.Company;

@SpringBootApplication
public class InternshipprojectApplication {
	@Autowired
	private CompanyRepository companyRepository;
	public static void main(String[] args) {
		SpringApplication.run(InternshipprojectApplication.class, args);
		
		
	}
//	@Override
//	public void run(String... args) throws Exception {
//		List<Company> Companys = Arrays.asList(
//				new Company("Company1", 10, 10, 10, 10, 10, 10, 10, 10, 10, 0),
//				new Company("Company2", 20, 20, 20, 20, 20, 20, 20, 20, 20, 0),
//				new Company("Company3", 30, 30, 30, 30, 30, 30, 30, 30, 30, 0),
//				new Company("Company4", 40, 40, 40, 40, 40, 40, 40, 40, 40, 0),
//				new Company("Company5", 50, 50, 50, 50, 50, 50, 50, 50, 50, 0),
//				new Company("Company6", 60, 60, 60, 60, 60, 60, 60, 60, 60, 0),
//				new Company("Company7", 70, 70, 70, 70, 70, 70, 70, 70, 70, 0),
//				new Company("Company8", 80, 80, 80, 80, 80, 80, 80, 80, 80, 0),
//				new Company("Company9", 90, 90, 90, 90, 90, 90, 90, 90, 90, 0),
//				new Company("Company10", 100, 100, 100, 100, 100, 100, 100, 100, 100, 0),
//				new Company("Company11", 110, 110, 110, 110, 110, 110, 110, 110, 110, 0),
//				new Company("Company12", 120, 120, 120, 120, 120, 120, 120, 120, 120, 0),
//				new Company("Company13", 130, 130, 130, 130, 130, 130, 130, 130, 130, 0),
//				new Company("Company14", 140, 140, 140, 140, 140, 140, 140, 140, 140, 0),
//				new Company("Company15", 150, 150, 150, 150, 150, 150, 150, 150, 150, 0),
//				new Company("Company16", 160, 160, 160, 160, 160, 160, 160, 160, 160, 0),
//				new Company("Company17", 170, 170, 170, 170, 170, 170, 170, 170, 170, 0),
//				new Company("Company18", 180, 180, 180, 180, 180, 180, 180, 180, 180, 0),
//				new Company("Company19", 190, 190, 190, 190, 190, 190, 190, 190, 190, 0),
//				new Company("Company20", 200, 200, 200, 200, 200, 200, 200, 200, 200, 0),
//				new Company("Company21", 210, 210, 210, 210, 210, 210, 210, 210, 210, 0),
//				new Company("Company22", 220, 220, 220, 220, 220, 220, 220, 220, 220, 0),
//				new Company("Company23", 230, 230, 230, 230, 230, 230, 230, 230, 230, 0),
//				new Company("Company24", 240, 240, 240, 240, 240, 240, 240, 240, 240, 0),
//				new Company("Company25", 250, 250, 250, 250, 250, 250, 250, 250, 250, 0),
//				new Company("Company26", 260, 260, 260, 260, 260, 260, 260, 260, 260, 0),
//				new Company("Company27", 270, 270, 270, 270, 270, 270, 270, 270, 270, 0),
//				new Company("Company28", 280, 280, 280, 280, 280, 280, 280, 280, 280, 0),
//				new Company("Company29", 290, 290, 290, 290, 290, 290, 290, 290, 290, 0),
//				new Company("Company30", 300, 300, 300, 300, 300, 300, 300, 300, 300, 0),
//				new Company("Company31", 310, 310, 310, 310, 310, 310, 310, 310, 310, 0),
//				new Company( "Company32", 320, 320, 320, 320, 320, 320, 320, 320, 320, 0),
//				new Company( "Company33", 330, 330, 330, 330, 330, 330, 330, 330, 330, 0),
//				new Company( "Company34", 340, 340, 340, 340, 340, 340, 340, 340, 340, 0),
//				new Company( "Company35", 350, 350, 350, 350, 350, 350, 350, 350, 350, 0),
//				new Company( "Company36", 360, 360, 360, 360, 360, 360, 360, 360, 360, 0),
//				new Company( "Company37", 370, 370, 370, 370, 370, 370, 370, 370, 370, 0),
//				new Company( "Company38", 380, 380, 380, 380, 380, 380, 380, 380, 380, 0),
//				new Company( "Company39", 390, 390, 390, 390, 390, 390, 390, 390, 390, 0),
//				new Company( "Company40", 400, 400, 400, 400, 400, 400, 400, 400, 400, 0),
//				new Company("Company41", 410, 410, 410, 410, 410, 410, 410, 410, 410, 0),
//				new Company( "Company42", 420, 420, 420, 420, 420, 420, 420, 420, 420, 0),
//				new Company( "Company43", 430, 430, 430, 430, 430, 430, 430, 430, 430, 0),
//				new Company( "Company44", 440, 440, 440, 440, 440, 440, 440, 440, 440, 0),
//				new Company( "Company45", 450, 450, 450, 450, 450, 450, 450, 450, 450, 0),
//				new Company( "Company46", 460, 460, 460, 460, 460, 460, 460, 460, 460, 0),
//				new Company( "Company47", 470, 470, 470, 470, 470, 470, 470, 470, 470, 0),
//				new Company( "Company48", 480, 480, 480, 480, 480, 480, 480, 480, 480, 0),
//				new Company( "Company49", 490, 490, 490, 490, 490, 490, 490, 490, 490, 0),
//				new Company( "Company50", 500, 500, 500, 500, 500, 500, 500, 500, 500, 0));
//		
//		companyRepository.saveAll(Companys);
//	}


}
