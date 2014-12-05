(define builtin- -)
(define (b- x y) (builtin- x y))




(define (- . l)
    (let
        ((x (car l))
         (list (cdr l))
         (minus (lambda (y)
                    (if (null? y) 0
                        (begin
                            (b- x y)
                            (minus (cdr y)))))))))

