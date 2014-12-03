(define (append l x)(if (null? l) x (cons (car l) (append (cdr l) x))))
(append '(1 2) 4)
(define (reverse l)
    (let (acc '())
        (append acc (car l))
        (reverse (cdr l) acc)))

(reverse '(1 2 3))