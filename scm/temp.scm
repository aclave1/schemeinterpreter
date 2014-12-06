

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

(define (for-each f . l)
    (if (not (null? (car l)))
        (begin
            (apply f (map car l))
            (apply for-each f (map cdr l)))))

(define (ddisplay x y)
    (begin (display x)(display":")(display y)(newline)))

(for-each ddisplay '(1 2) '(3 4))


