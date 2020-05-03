package com.example.demo;

import com.example.demo.entities.Album;
import com.example.demo.repository.AlbumRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//@SpringBootApplication
public class JpaProgramFinalApplication {

	public static void main(String[] args) {
//		SpringApplication.run(JpaProgramFinalApplication.class, args);

		AlbumRepository albumRepository = new AlbumRepository();
		Album album = new Album();

		System.out.println(albumRepository.findByName("Hamburger"));
	}
}
