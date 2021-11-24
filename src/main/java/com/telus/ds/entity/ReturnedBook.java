package com.telus.ds.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "returnedbooks")

public class ReturnedBook {

    public ReturnedBook() {
    }

    public ReturnedBook(LocalDateTime returnedDate) {
        super();
        this.returnedDate = returnedDate;

    }

    @Id
    @Column(name = "id_returned_books", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReturnedBooks;

    /*@Column(name="idBook2", updatable=false)
	@NotNull(message = "idBook2 is required")
	private Integer idBook2;
	
	@Column(name="idUserClient2", updatable=false)
	@NotNull(message = "idUserClient2 is required")
	private Integer idUserClient2;*/
    @Column(name = "returned_date", updatable = false)
    @NotNull(message = "returnedDate is required")
    private LocalDateTime returnedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_book2", nullable = false)
    @NotNull(message = "Book is required")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Book bookObj;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_client2", nullable = false)
    @NotNull(message = "User is required")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User userObj;

}