.class public final Lb/a/a/b/a/c;
.super Lb/a/a/b/a/d;
.source ""


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lb/a/a/b/a/c$a;
    }
.end annotation


# direct methods
.method public static a(Lb/a/a/b/a/e;Lb/a/a/b/a/b;Ljava/util/concurrent/Executor;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<V:",
            "Ljava/lang/Object;",
            ">(",
            "Lb/a/a/b/a/e<",
            "TV;>;",
            "Lb/a/a/b/a/b<",
            "-TV;>;",
            "Ljava/util/concurrent/Executor;",
            ")V"
        }
    .end annotation

    invoke-static {p1}, Lb/a/a/a/b;->b(Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v0, Lb/a/a/b/a/c$a;

    invoke-direct {v0, p0, p1}, Lb/a/a/b/a/c$a;-><init>(Ljava/util/concurrent/Future;Lb/a/a/b/a/b;)V

    invoke-interface {p0, v0, p2}, Lb/a/a/b/a/e;->a(Ljava/lang/Runnable;Ljava/util/concurrent/Executor;)V

    return-void
.end method

.method public static b(Ljava/util/concurrent/Future;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<V:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/concurrent/Future<",
            "TV;>;)TV;"
        }
    .end annotation

    invoke-interface {p0}, Ljava/util/concurrent/Future;->isDone()Z

    move-result v0

    const-string v1, "Future was expected to be done: %s"

    invoke-static {v0, v1, p0}, Lb/a/a/a/b;->d(ZLjava/lang/String;Ljava/lang/Object;)V

    invoke-static {p0}, Lb/a/a/b/a/h;->a(Ljava/util/concurrent/Future;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method
