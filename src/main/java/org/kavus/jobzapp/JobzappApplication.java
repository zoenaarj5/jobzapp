package org.kavus.jobzapp;

import org.kavus.jobzapp.entity.*;
import org.kavus.jobzapp.repo.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class JobzappApplication {
	protected static final Person person1=new Person(new LoginData("joedalton","joedalton@western.com","JoeDalton1"),new PersonalData("Joe","Dalton",LocalDate.of(1860,12,1), Sex.M));
	protected static final Person person2=new Person(new LoginData("calamityjane","calamityjane@western.com","CalamityJane1"),new PersonalData("Martha Jane","Cannary",LocalDate.of(1852,5,1), Sex.F));
	protected static final Person person3=new Person(new LoginData("luckyluke","luckyluke@western.com","LuckyLuke1"),new PersonalData("Lucky","Luke",LocalDate.of(1857,4,22), Sex.M));
	protected static final LDefinition company1DefinitionEN=new LDefinition(null,LanguageCode.EN,"Alter Solutions SA","","");
	protected static final LDefinition company1DefinitionFR=new LDefinition(null,LanguageCode.FR,"Alter Solutions SA","","");
	protected static final LDefinition company2DefinitionEN=new LDefinition(null,LanguageCode.EN,"","","");
	protected static final LDefinition company2DefinitionFR=new LDefinition(null,LanguageCode.FR,"","","");
	protected static final Company company1=new Company(Arrays.asList(new Definition[]{company1DefinitionEN,company1DefinitionFR}),LocalDate.of(2006,2,1), LocalDateTime.of(2019,12,1,11,41));
	protected static final Company company2=new Company(Arrays.asList(new Definition[]{company2DefinitionEN,company2DefinitionFR}),LocalDate.of(2006,2,1), LocalDateTime.of(2019,12,1,11,41));
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
