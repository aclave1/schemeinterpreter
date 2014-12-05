(define builtin- -)
(define (b- x y) (builtin- x y))

;;iterates over the list and returns l if pred function is true when called with x and l as args
(define (retlist pred x l)
    (cond
        ((null? l) #f)
        ((pred x (car l)) l)
        (else (memq x (cdr l)))))

(define (memq x l)
    (retlist eq? x l))
(define (memv x l)
    (retlist eqv? x l))
(define (member x l)
    (retlist equal? x l))


(memq 'a '( f p a q  b c))
(memv 'a '( f p a q  b c))
(member 'a '( f p a q  b c))