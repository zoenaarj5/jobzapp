package org.kavus.jobzapp;

import org.apache.tomcat.jni.Local;
import org.kavus.jobzapp.entity.*;
import org.kavus.jobzapp.repo.*;
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
	protected static final Company company1=new Company(LocalDate.of(2006,2,1), LocalDateTime.of(2019,12,1,11,41));
	protected static final Company company2=new Company(LocalDate.of(2006,2,1), LocalDateTime.of(2019,12,1,11,41));
	protected static final LDefinition company1DefinitionEN=new LDefinition(company1,LanguageCode.EN,"Alter Solutions SA","A perfect company","This is what you need as a consulance company.");
	protected static final LDefinition company1DefinitionFR=new LDefinition(company1,LanguageCode.FR,"Alter Solutions SA","Une entreprise parfaite.","Exactement ce que vous cherchez comme société de consultance.");
	protected static final LDefinition company2DefinitionEN=new LDefinition(company2,LanguageCode.EN,"IBM","A well-known IT giant","This is a company with a well-documented history of successes");
	protected static final LDefinition company2DefinitionFR=new LDefinition(company2,LanguageCode.FR,"IBM","Un célèbre géant de l'informatique.","Ceci est une société avec une histoire á succès bien documentée.");
	protected static final ExperienceType experienceType1=new ExperienceType();
	protected static final ExperienceType experienceType2=new ExperienceType();
	protected static final Experience experience111=new Experience(person1,company1,experienceType1,LocalDate.of(2010,6,1),LocalDate.of(2012,7,5));
	protected static final Experience experience112=new Experience(person1,company2,experienceType1,LocalDate.of(2015,4,20), LocalDate.of(2017,4,19));
	protected static final Experience experience211=new Experience(person2,company1,experienceType1,LocalDate.of(2010,6,1),LocalDate.of(2012,7,5));
	protected static final Experience experience212=new Experience(person1,company1,experienceType2,LocalDate.of(2015,4,20), LocalDate.of(2017,4,19));
	protected static final LDefinition experienceType1ENDefinition=new LDefinition(experienceType1,LanguageCode.EN,"Java Back-End Developer","Java development: model and data access","JBED Bla bla bla bla bla bla");
	protected static final LDefinition experienceType1FRDefinition=new LDefinition(experienceType1,LanguageCode.FR,"Développeur Java Back-End","Développement Java: modèle et accès aux données","DJBE Bla bla bla bla bla bla");
	protected static final LDefinition experienceType2ENDefinition=new LDefinition(experienceType2,LanguageCode.EN,"Java Front-End Developer","Java development: views and controllers","JFED Bla bla bla bla bla bla");
	protected static final LDefinition experienceType2FRDefinition=new LDefinition(experienceType2,LanguageCode.FR,"Développeur Java Front-End","Développement Java: vues et contróleurs","DJFE Bla bla bla bla bla bla");
	public static void main(String[] args) {
		SpringApplication.run(JobzappApplication.class, args);
	}
	@Bean
	public CommandLineRunner demoExperienceType(ExperienceTypeRepository repository){
		final ExperienceType[] ets=new ExperienceType[]{experienceType1,experienceType2};
		return args -> {
			Arrays.stream(ets).forEach((et)->{
				repository.save(et);
			});
		};
	}
	@Bean
	public CommandLineRunner demoOrganization(OrganizationRepository repository){
		return (args)->{
			repository.save(company1);
			repository.save(company2);
		};
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
	@Bean
	public CommandLineRunner demoAsset(AssetRepository repository){
		final Asset[] assets=new Asset[]{experience111,experience112,experience211,experience212};
		return (args)->{
			Arrays.stream(assets).forEach((a)->{
				repository.save(a);
			});
		};
	}
	@Bean
	public CommandLineRunner demoJob(JobRepository repository){
		final Job[] jobs=new Job[]{};
		return (args)->{
			Arrays.stream(jobs).forEach((job)->{
				repository.save(job);
			});
		};
	}
	@Bean
	public CommandLineRunner demoDefinition(DefinitionRepository repository){
		final Definition[] dList=new Definition[]{
				company1DefinitionFR,company1DefinitionEN,company2DefinitionFR,company2DefinitionEN,
				experienceType1ENDefinition,experienceType1FRDefinition,experienceType2ENDefinition,experienceType2FRDefinition
		};
		return (args)->{
			Arrays.stream(dList).forEach((def)->{repository.save(def);});
		};
	}
}
