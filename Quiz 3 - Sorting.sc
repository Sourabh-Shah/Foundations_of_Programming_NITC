; Main Function "SortAscending"
(define (SortAscending listOfNumbers)
    (if (null? listOfNumbers)
        '()
        (cons (Minimum listOfNumbers) (SortAscending (RemoveElement (Minimum listOfNumbers) listOfNumbers)))
        )
)

; Sub Function "Minimum" to find minimum value from the list
(define (Minimum listOfNumbers)
    (if (null? (cdr listOfNumbers))
        (car listOfNumbers)
        (if (< (car listOfNumbers) (Minimum (cdr listOfNumbers)))
            (car listOfNumbers)
            (Minimum (cdr listOfNumbers))
            )
        )
)

; Sub Function "RemoveElement" to remove the first occurence of value from the list
(define (RemoveElement value listOfNumbers)
    (if (null? listOfNumbers)
        '()
        (if (= value (car listOfNumbers))
            (cdr listOfNumbers)
            (cons (car listOfNumbers) (RemoveElement value (cdr listOfNumbers)))
            )
        )
    )

;Test of code for arbitary input
(define a (list 1 89 24 5 6 9 7 0 5 -89 -8 -8 7 93 15 8 69 ))
(display (SortAscending a))