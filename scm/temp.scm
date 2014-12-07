(define builtin= =)
(define (b= x y) (builtin= x y))
(define builtin< <)
(define (b< x y) (builtin< x y))
(define builtin> >)
(define (b> x y) (builtin> x y))
(define builtin<= <=)
(define (b<= x y) (builtin<= x y))
(define builtin>= >=)
(define (b>= x y) (builtin>= x y))

(define (listcomp f x . l)
  (cond
    ((null? l) #t)
    ((f x (car l))(apply = x (cdr l)))
    (else #f)))



(define (< x . l)(apply listcomp b< x l))
(define (<= x . l)(apply listcomp b<= x l))
(define (= x . l)(apply listcomp b= x l))


(< 1 2 3)
(<= 1 1 2 2 3 3)
(= 1 1 1)