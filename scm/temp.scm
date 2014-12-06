(define (eqv? x y)
    (cond
        (and (number? x) (number? y) (= x y))
        (else (eq? x y))))
(define (equal? x y)
    (cond
        (and (list? x)(list? y)
             (begin
                 (eq? (car x) (car y))
                 (equal? (cdr x) (cdr y))))
        (else (eq? x y))))



(equal? '(1 2) '(1 2))
(equal? "alex" "alex")