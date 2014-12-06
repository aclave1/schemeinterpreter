(define (eqv? x y)
    (if (eq? (car x) (car y))
        (eqv? (cdr x) (cdr y))
        #f))

(eqv? "cat" "cat")

(define (nexecute x)())




