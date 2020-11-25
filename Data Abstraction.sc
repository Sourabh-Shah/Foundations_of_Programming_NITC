;Constructoe and selectors for ""
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
(define (recent-dob dob1 dob2)
    (cond ((> (get-year dob1) (get-year dob2)) dob1)
          ((< (get-year dob1) (get-year dob2)) dob2)
          ((> (get-month dob1) (get-month dob2)) dob1)
          ((< (get-month dob1) (get-month dob2)) dob2)
          ((> (get-day dob1) (get-day dob2)) dob1)
          (else dob2)
          )
)

;Constructor and selector for "doblist"
(define (make-doblist . args)
    args
    )
(define (get-first-dob doblist)
    (car doblist)
    )
(define (get-second-dob doblist)
    (cadr doblist)
    )
(define (get-rest-dobs doblist)
    (cdr doblist)
    )
(define (isEmpty? doblist)
    (null? doblist)
    )
(define (most-recent-dob doblist)
    (cond ((isEmpty? doblist) 'Error_empty_list)
          ((isEmpty? (get-rest-dobs doblist)) (get-first-dob doblist))
          ((isEmpty? (get-rest-dobs (get-rest-dobs doblist))) (recent-dob (get-first-dob doblist) (get-second-dob doblist)))
          (else (recent-dob (get-first-dob doblist) (most-recent-dob (get-rest-dobs doblist))))
    )
)
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
(define (make-person name dob)
    (list name dob)
    )
(define (get-name person)
    (car person)
    )
(define (get-dob person)
    (cadr person)
    )
(define (get-younger p1 p2)
    (if (equal? (recent-dob (get-dob p1) (get-dob p2)) (get-dob p1))
        p1
        p2
        )
    )
(define (get-youngest-person person-db)
     (cond ((isEmpty? person-db) 'Error_empty_list)
          ((isEmpty? (get-rest-of-db person-db)) (get-first-person person-db))
          ((isEmpty? (get-rest-of-db (get-rest-of-db person-db))) (get-younger (get-first-person person-db) (get-second-person person-db)))
          (else (get-younger (get-first-person person-db) (get-youngest-person (get-rest-of-db person-db))))
    )
    )
(define p1 (make-person "Sourabh" (list 02 10 1998)))
(define p2 (make-person "Vinit" (list 18 07 2001)))
(define p3 (make-person "xxx" (list 02 10 1999)))
(define person-db (make-person-db p1 p2 p3))
(display (get-youngest-person person-db))
