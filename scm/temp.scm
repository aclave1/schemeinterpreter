(define (caar l) (car(car l)))
(define (caaar l) (car(car (car l))))
(define (caaaar l) (car(car (car (car l)))))
(define (cadr l) (car(cdr l)))
(define (caddr l) (car(cdr (cdr l))))
(define (cadddr l) (car(cdr (cdr (cdr l)))))
(define (cdar l) (cdr(car l)))
(define (cddar l) (cdr(cdr (car l))))
(define (cdddar l) (cdr(cdr (cdr (car l)))))
(define (cddddr l) (cdr(cdr (cdr (cdr l)))))
(define (cdddr l) (cdr(cdr (cdr l))))
(define (cddr l) (cdr(cdr l)))
(define (cadar l) (car(cdr (car l))))
(define (caadar l) (car(car (cdr (car l)))))
(define (cadaar l) (car(cdr (car (car l)))))


(define (cdadarr l) (cdr(car (cdr (car l)))))
