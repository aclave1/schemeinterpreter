(define (and . l)
    (if (null? (cdr l)) (car l)
        (if (eq? (car l) #f) #f (apply and (cdr l)))))


(and (= 1 1) 1 "chicken" )

