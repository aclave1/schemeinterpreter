;;overwrites the scheme48 builtin functions

(define (assert pred) (if pred (display "passed\n")(display "failed\n")))


(define builtin-+ +)
(define (b+ x y) (builtin-+ x y))
(define builtin- -)
(define (b- x y) (builtin- x y))
(define builtin* *)
(define (b* x y) (builtin* x y))

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


(define builtinmax max)
(define (bmax x y) (builtinmax x y))
(define builtinmin min)
(define (bmin x y) (builtinmin x y))

