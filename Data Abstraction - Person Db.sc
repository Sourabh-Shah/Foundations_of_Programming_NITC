; Constructor and selectors for "person-db"
(define (make-person-db . args)
    args
    )
(define (get-first-person person-db)
    (car person-db)
    )
(define (get-second-person person-db)
    (cadr person-db)
    )
(define (get-rest-of-db person-db)
    (cdr person-db)
    )
(define (isEmpty? person-db)
    (null? person-db)
    )

; Constructor and selectors for "person"
(define (make-person name dob)
    (list name dob)
    )
(define (get-name person)
    (car person)
    )
(define (get-dob person)
    (cadr person)
    )

; Constructor and selectors for "dob"
(define (make-dob dd mm yyyy)
    (list dd mm yyyy)
    )
(define (get-day dob)
    (car dob)
    )
(define (get-month dob)
    (cadr dob)
    )
(define (get-year dob)
    (caddr dob)
    )

;"get-younger" takes two person and returns the younger person
(define (get-younger p1 p2)
    (if (equal? (recent-date (get-dob p1) (get-dob p2)) (get-dob p1))
        p1
        p2
        )
    )

; "find-youngest-person-name" takes person-db and returns the name of youngest person
(define (find-youngest-person-name person-db)
    (if (is-Empty? person-db)
        'Error_empty_person-db
        (get-name (get-youngest-person person-db))
        )
)