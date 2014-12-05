(define (assochelper pred key list)
    (cond
        ((null? list) '())
        ((pred key (caar list)) (car list))
        (else (assochelper pred key (cdr list)))))

(define (assq x l)(assochelper eq? x l))
(define (assv x l)(assochelper eqv? x l))
(define (assoc x l)(assochelper equal? x l))

(define e '((a 1) (b 2) (c 3)))
(assq 'a e)

(define e '((a 1) (b 2) (c 3)))
(assv 'a e)

(define e '((a 1) (b 2) (c 3)))
(assoc 'a e)
