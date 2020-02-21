package org.kavus.jobzapp;

import org.kavus.jobzapp.entity.*;
import org.kavus.jobzapp.repo.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class JobzappApplication {
	protected static final Person person1=new Person(new LoginData("joedalton","joedalton@western.com","JoeDalton1"),new PersonalData("Joe","Dalton",LocalDate.of(1860,12,1), Sex.M));
	protected static final Person person2=new Person(new LoginData("calamityjane","calamityjane@western.com","CalamityJane1"),new PersonalData("Martha Jane","Cannary",LocalDate.of(1852,5,1), Sex.F));
	protected static final Person person3=new Person(new LoginData("luckyluke","luckyluke@western.com","LuckyLuke1"),new PersonalData("Lucky","Luke",LocalDate.of(1857,4,22), Sex.M));
	protected static final Company company1=new Company(LocalDate.of(2006,2,1), LocalDateTime.of(2019,12,1,11,41));
	protected static final Company company2=new Company(LocalDate.of(2006,2,1), LocalDateTime.of(2019,12,1,11,41));
	protected static final LDefinition company1DefinitionEN=new LDefinition(company1,LanguageCode.EN,"Alter Solutions SA","A perfect company","This is what you need as a consulance company.");
	protected static final LDefinition company1DefinitionFR=new LDefinition(company1,LanguageCode.FR,"Alter Solutions SA","Une entreprise parfaite.","Exactement ce que vous cherchez comme société de consultance.");
	protected static final LDefinition company2DefinitionEN=new LDefinition(company2,LanguageCode.EN,"IBM","A well-known IT giant","This is a company with a well-documented history of successes");
	protected static final LDefinition company2DefinitionFR=new LDefinition(company2,LanguageCode.FR,"IBM","Un célèbre géant de l'informatique.","Ceci est une société avec une histoire á succès bien documentée.");
	public static void main(String[] args) {
		SpringApplication.run(JobzappApplication.class, args);
	}
	@Bean
	public CommandLineRunner demoPerson(PersonRepository repository){
		return (args)->{
			Arrays.asList(new Person[]{person1,person2,person3}).stream().forEach(
					(person)->	repository.save(person)
			);
			for(Person person:repository.findAll()){
				System.out.print("ID:\t");
				System.out.println(person.getId());
				System.out.print((person.getPersonalData().getSex()==Sex.F?"Mrs":"Mr")+"\t");
				System.out.print(person.getPersonalData().getFirstName());
				System.out.print(" \t");
				System.out.println(person.getPersonalData().getLastName());
				System.out.print("BORN ON:\t");
				System.out.println(person.getPersonalData().getBirthDate());
				System.out.print("EMAIL:\t");
				System.out.println(person.getLoginData().getEmail());
				System.out.print("USER NAME:\t");
				System.out.println(person.getLoginData().getUserName());
				System.out.print("PASSWORD:\t");
				System.out.println(person.getLoginData().getPassword());
			}
		};
	}
}
