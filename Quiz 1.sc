; Main Function "OccurenceOfMinimumValue" 
(define (OccurenceOfMinimumValue listOfNumbers)
    (if (null? listOfNumbers)
        (display "List is Empty")
        (Occurence listOfNumbers (Minimum listOfNumbers))
        )
    )

; Sub Function "Maximum" to get the Minimum Value
(define (Minimum listOfNumbers)
    (if (null? (cdr listOfNumbers))
        (car listOfNumbers)
        (if (< (car listOfNumbers) (Minimum (cdr listOfNumbers)))
               (car listOfNumbers)
               (Minimum (cdr listOfNumbers))
               )
        )
    )

; Sub Function "Occurence" to find the occurence of a value in list
(define (Occurence listOfNumbers value)
    (if (null? listOfNumbers)
        0
        (if (= value (car listOfNumbers))
            (+ 1 (Occurence (cdr listOfNumbers) value))
            (Occurence (cdr listOfNumbers) value)
            )
        )
    )

; Test of code for an arbitary input list
(define a (list 5 5 5 5 5 5 1 2 3 4 5 9 1 ))
(display (OccurenceOfMinimumValue a))