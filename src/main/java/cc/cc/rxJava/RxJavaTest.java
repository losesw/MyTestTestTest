/**
 * @Version 1.0.0
 * Copyright (c) 2018上海相诚金融-版权所有
 */
package cc.cc.rxJava;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Class RxJavaTest
 * @Description
 * @Author 张超超
 * @Date 2018/6/1 15:59
 */
@Slf4j
public class RxJavaTest {
    public static void main(String[] args) throws Exception {
        RxJavaTest t = new RxJavaTest();
//        t.simple();
//        t.normal();
//        t.testNew();
//        t.testMap();
//        t.testZip();
//        t.testConcact();
//        t.testFlatMap();
//        t.testConcatMap();
//        t.testObserverOn(); //todo
//        t.testSubsribeOn(); //todo
//        t.testCommonMethods();
        t.testDeferredDependent();

    }


    private void testDeferredDependent() throws Exception {
        AtomicInteger count = new AtomicInteger();

//        count.incrementAndGet();
//        int i = count.get();
//        log.info("count : " + i);

        Observable.range(1, 10)
                .doOnNext(ignored -> {count.incrementAndGet();log.info("value : " + ignored + " | count : " + count);})
                .ignoreElements()
                .andThen(Single.just(count.get()))
                .subscribe(System.out::println);
        System.out.println("---------------");

        count.set(0);
        Observable.range(1, 10)
                .doOnNext(ignored -> count.incrementAndGet())
                .ignoreElements()
                .andThen(Single.defer(() -> {log.info("count : " + count.get());return Single.just(count.get());}))
                .subscribe(System.out::println);
        System.out.println("---------------");

        count.set(0);
        Observable.range(1, 10)
                .doOnNext(ignored -> count.incrementAndGet())
                .ignoreElements()
                .andThen(Observable.defer(() -> Observable.just(count.get())))
                .subscribe(System.out::println);
        System.out.println("---------------");

        count.set(0);
        Observable.range(1,5)
                .doOnNext(ignored -> count.incrementAndGet())
                .flatMapSingle(ignore -> Single.just(count.get()))
                .subscribe(System.out::println);
    }

    private void testCommonMethods() throws Exception {
        int time = 1000;
        log.info("take -->");
        Observable.just(1,2,3,4,5)
                .take(3)
                .subscribe(getConsumerInteger());
        log.info("--------------------");
        Thread.sleep(time);

        log.info("distinct -->");
        Observable.just(1,1,2,2,3,3,3,4,5,5)
                .distinct()
                .subscribe(getConsumerInteger());
        log.info("--------------------");
        Thread.sleep(time);

        log.info("filter -->");
        Observable.just(1,2,2,3,4,4,55)
                .filter(i -> i > 2)
                .subscribe(getConsumerInteger());
        log.info("--------------------");
        Thread.sleep(time);

        log.info("sorted -->");
        Observable.just(1,1,2,2,3,3,3,3)
                .sorted((x,y) -> y.compareTo(x))
                .subscribe(getConsumerInteger());
        log.info("--------------------");
        Thread.sleep(time);

        log.info("skip -->");
        Observable.just(1,1,2,2,3,3,3,3)
                .skip(4)
                .subscribe(getConsumerInteger());
        log.info("--------------------");
        Thread.sleep(time);

        log.info("buffer -->");
        Observable.just(1,2,2,2,3,4,4,5,6,7)
                .buffer(2, 3) //skip:跳过多少items，原始操作会依次触发每个item
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        log.info("size : " + integers);
                        for(Integer i : integers) {
                            log.info("" + i);
                        }
                    }
                });
        log.info("--------------------");
        Thread.sleep(time);

        log.info("timer -->");
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribe(getConsumerLong());
        log.info("--------------------");
        Thread.sleep(time);

        log.info("interval -->");
        Observable.interval(3, 2, TimeUnit.SECONDS)
                .subscribe(getConsumerLong());
        log.info("--------------------");
        Thread.sleep(time);
        Thread.sleep(10000);
    }

    private Consumer<Long> getConsumerLong() throws Exception {
        return new Consumer<Long>() {
            @Override
            public void accept(Long l) throws Exception {
                log.info("accept : " + l);
            }
        };
    }

    private Consumer<Integer> getConsumerInteger() throws Exception {
        return new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                log.info("accept : " + integer);
            }
        };
    }

    //todo
    private void testObserverOn() throws Exception {

    }

    //todo
    private void testSubsribeOn() throws Exception {

    }

    //有序
    private void testConcatMap() throws Exception {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(0);
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
            }
        }).concatMap(new Function<Integer, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i=0; i<3; i++) {
                    list.add("now value is " + integer);
                }
                return Observable.fromIterable(list).delay((int) (1 + Math.random() * 10), TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                log.info("accept " + o);
            }
        });
        Thread.sleep(10000);
    }

    //无序
    private void testFlatMap() throws Exception {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(0);
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
            }
        }).flatMap(new Function<Integer, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int i=0; i<3; i++) {
                    list.add("now value is " + integer);
                }
                return Observable.fromIterable(list).delay((int) (1 + Math.random() * 10), TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                log.info("accept " + o);
            }
        });
        Thread.sleep(10000);
    }

    private void testConcact() throws Exception {
        Observable.concat(Observable.just(0,2,4), Observable.just("1","3",5,7,9))
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object integer) throws Exception {
                        log.info("accept : " + integer);
                    }
                });
    }


    private void testZip() throws Exception {
        Observable.zip(getStringObservable(), getIntegerObservable(), new BiFunction<String, Integer, String>() {
            @Override
            public String apply(String s, Integer integer) throws Exception {
                return "value1 : " + s + " , value2 : " + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                log.info("accept : " + s);
            }
        });
//        Thread.sleep(5000);
    }


    private Observable<String> getStringObservable() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("value is 0");
                log.info("subscribe value is 0");
                emitter.onNext("value is 1");
                log.info("subscribe value is 1");
                emitter.onNext("value is 2");
                log.info("subscribe value is 2");
            }
        });
    }

    private Observable<Integer> getIntegerObservable() {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(100);
                log.info("subscribe " + 100);
//                emitter.onError(new Exception());
                emitter.onComplete();
                emitter.onNext(101);
                log.info("subscribe " + 101);
                emitter.onNext(102);
                log.info("subscribe " + 102);
                emitter.onNext(103);
                log.info("subscribe " + 103);
                emitter.onNext(104);
                log.info("subscribe " + 104);
            }
        });
    }

    private void testMap() throws Exception {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(0);
                log.info("onNext : " + 0);
                emitter.onNext(1);
                log.info("onNext : " + 1);
                emitter.onNext(2);
                log.info("onNext : " + 2);
                emitter.onNext(3);
                log.info("onNext : " + 3);
            }
        })
                .map(o -> "value is " + o)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        log.info("accept : " + s);
                    }
                });
        Thread.sleep(5000);
    }

    private void testNew() throws Exception {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(0);
                log.info("emitter 0");
                emitter.onNext(2);
                log.info("emitter 2");
                emitter.onNext(4);
                log.info("emitter 4");
                log.info("isDisposed " + emitter.isDisposed());
                emitter.onNext(1);
                log.info("emitter 1");
                emitter.onError(new Exception());
                emitter.onNext(3);
                log.info("emitter 3");
                emitter.onComplete();
                emitter.onNext(5);
                log.info("emitter 5");
                log.info("isDisposed " + emitter.isDisposed());

            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                log.info("onSubscribe " + d);
            }

            @Override
            public void onNext(Integer integer) {
                log.info("onNext " + integer);
            }

            @Override
            public void onError(Throwable e) {
                log.info("onError ...");
            }

            @Override
            public void onComplete() {
                log.info("onComplete ...");
            }
        });
        Thread.sleep(10000);
    }

    private void normal() throws Exception {
//        Flowable<Integer> hot = Flowable.just(500);
//        System.out.println("first");
//        Disposable first = hot.subscribe(i -> System.out.println(i));
//        Thread.sleep(3000);
//        Disposable second = hot.subscribe(i -> System.out.println(i));

        Flowable<Long> hot = Flowable.interval(400, TimeUnit.MILLISECONDS);
        System.out.println("first");
        Disposable first = hot.subscribe(i -> System.out.println("first" + i));
        Thread.sleep(3000);
        System.out.println("second");
        Disposable second = hot.subscribe(i -> System.out.println("second" + i));
        Thread.sleep(3000);
    }

    private void simple() throws Exception {
        String str = "rxJava first test !";
        Flowable.just(str).subscribe(System.out::println);
        Thread.sleep(3000);
        Flowable.just(str).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });
    }
}
