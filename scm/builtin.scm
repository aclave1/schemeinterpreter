;;overwrites the scheme48 builtin functions



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

