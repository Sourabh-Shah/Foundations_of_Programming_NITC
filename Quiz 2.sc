; Main Function "DeleteMaximum"
(define (DeleteMaximum listOfNumbers)
    (if (null? listOfNumbers)
        (display "List is Empty")
        (RemoveElement (Maximum listOfNumbers) listOfNumbers)
        )
    )

; Sub Function "Maximum" to find the maximum element in the list
(define (Maximum listOfNumbers)
    (if (null? (cdr listOfNumbers))
        (car listOfNumbers)
        (if (< (car listOfNumbers) (Maximum (cdr listOfNumbers)))
            (Maximum (cdr listOfNumbers))
            (car listOfNumbers)
            )
        )
    )

; Sub Function "RemoveElement" to remove a particular element from the list
(define (RemoveElement value listOfIntegers)
    (if (null? listOfIntegers)
        '()
        (if (= value (car listOfIntegers))
            (RemoveElement value (cdr listOfIntegers))
            (cons (car listOfIntegers) (RemoveElement value (cdr listOfIntegers)))
            )
        )
)

; Test of code for an arbitary input
(define a (list 4 3 5 2 1))  
(display (DeleteMaximum a))