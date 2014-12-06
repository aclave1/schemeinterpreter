

(define (unary-foreach f l)
    (if (not (null? l))
        (begin
            (f (car l))
            (unary-foreach f (cdr l)))))



(define (unary-map f l)
    (if (null? l) l
        (cons (f (car l)) (unary-map f (cdr l)))))
(define (map f . l)
    (if (null? (car l)) '()
        (cons (apply f (unary-map car l)) (apply map f (unary-map cdr l)))))


(map + '(1 1) '(2 2))
;(extractcars '(1 2) '(3 4) '(5 6))
;(extractcdrs '(1 2) '(3 4) '(5 6))


(define lst '((1 2) (3 4) (5 6)))


