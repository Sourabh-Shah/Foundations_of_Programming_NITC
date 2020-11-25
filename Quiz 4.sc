; Constructor and selectors for "emp-db"
(define make-emp-db list)
(define (get-first-emp-rec emp-db)
    (car emp-db)
    )
(define (get-second-emp-rec emp-db)
    (cadr emp-db)
    )
(define (get-rest-of-emp-recs emp-db)
    (cdr emp-db)
    )
(define (isEmpty? emp-db)
    (null? emp-db)
    )
(define (remove-emp emp emp-db)
    (if (isEmpty? emp-db)
        '()
        (if (equal? emp (get-first-emp-rec emp-db))
            (remove-emp  emp (get-rest-of-emp-recs emp-db))
            (cons (get-first-emp-rec emp-db) (remove-emp  emp (get-rest-of-emp-recs emp-db)))
            )
        )
    )

; Constructor and selector for "emp-rec"
(define (make-emp-rec name mon_sal DOJ)
    (list name mon_sal DOJ)
    )
(define (get-name emp-rec)
    (car emp-rec)
    )
(define (get-monthly-salary emp-rec)
    (cadr emp-rec)
    )
(define (get-DOJ emp-rec)
    (caddr emp-rec)
    )

; Constructor and selectors for "DOJ"
(define (make-DOJ dd mm yyyy)
    (list dd mm yyyy)
    )
(define (get-day DOJ)
    (car DOJ)
    )
(define (get-month DOJ)
    (cadr DOJ)
    )
(define (get-year DOJ)
    (caddr DOJ)
    )

; Main Function "get-reqd-db"
;INPUT - A database of emp-recs "emp-db"   
;OUTPUT - name of employee who joined after 01 01 2000 and have maximum salary
(define (get-reqd-emp emp-db)
    (if (isEmpty? emp-db)
        'Error_No_Such_Employee
        (if (Join-after (make-DOJ 01 01 2000) (get-DOJ (get-max-sal-emp emp-db)))
            (get-name (get-max-sal-emp emp-db))
            (get-reqd-emp (remove-emp (get-max-sal-emp emp-db) emp-db))
            )
        )
    )

; Sub-function "get-max-sal-emp"
; INPUT - A non-empty emp-db
; OUTPUT - employee with maximum salary
(define (get-max-sal-emp emp-db)
    (if (isEmpty? emp-db)
        'Error 
        (if (isEmpty? (get-rest-of-emp-recs emp-db))
            (get-first-emp-rec emp-db)  
            (if (> (get-monthly-salary (get-first-emp-rec emp-db)) (get-monthly-salary (get-max-sal-emp (get-rest-of-emp-recs emp-db))))
                (get-first-emp-rec emp-db)
                (get-max-sal-emp (get-rest-of-emp-recs emp-db))
                )
            )
        )
    )
; Sub-function "Join-After"
; INPUT - DOJ1 and DOJ2
; OUTPUT - returns #t if DOJ2 is after DOJ1, otherwise #f
(define (Join-after DOJ1 DOJ2)
     (cond ((> (get-year DOJ2) (get-year DOJ1)) #t)
           ((< (get-year DOJ2) (get-year DOJ1)) #f)
          ((> (get-month DOJ2) (get-month DOJ1)) #t)
          ((< (get-month DOJ2) (get-month DOJ1)) #f)
          ((> (get-day DOJ2) (get-day DOJ1)) #t)
          (else #f)
          )
    )
; sample input
(define emp1 (make-emp-rec "Sourabh" 20000 (make-DOJ 01 11 1999)))
(define emp2 (make-emp-rec "Vinit" 40000 (make-DOJ 10 01 2001)))
(define emp3 (make-emp-rec "Prince" 60000 (make-DOJ 01 11 1998)))
(define emp4 (make-emp-rec "Satyendra" 30000 (make-DOJ 02 09 2012)))
(define emp-db (make-emp-db emp1 emp2 emp3 emp4))
(display (get-reqd-emp emp-db))