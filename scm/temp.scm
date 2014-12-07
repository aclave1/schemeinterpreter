(define (eqv? x y)
    (cond
        (and ((number? x) (number? y) (= x y)))
        (else (eq? x y))))
(define (equal? x y)
    (cond
        (if (and (list? x) (list? y))
            (begin
                (eq? (car x) (car y))
                (equal? (cdr x) (cdr y)))
            (eq? x y))))


(equal? '(1 2) '(1 2))
(equal? "alex" "alex")


(eqv? 'y 'y)



(- 6 2)