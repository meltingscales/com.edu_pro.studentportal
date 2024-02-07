.class Lio/flutter/plugins/b/h$d;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Lio/flutter/plugins/b/h$c;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/flutter/plugins/b/h;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "d"
.end annotation


# instance fields
.field private final a:Ljava/util/concurrent/Executor;

.field private final b:Ljava/util/concurrent/Executor;

.field final synthetic c:Lio/flutter/plugins/b/h;


# direct methods
.method private constructor <init>(Lio/flutter/plugins/b/h;)V
    .locals 1

    iput-object p1, p0, Lio/flutter/plugins/b/h$d;->c:Lio/flutter/plugins/b/h;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance p1, Lio/flutter/plugins/b/h$e;

    const/4 v0, 0x0

    invoke-direct {p1, v0}, Lio/flutter/plugins/b/h$e;-><init>(Lio/flutter/plugins/b/h$a;)V

    iput-object p1, p0, Lio/flutter/plugins/b/h$d;->a:Ljava/util/concurrent/Executor;

    new-instance p1, Lb/a/a/b/a/g;

    invoke-direct {p1}, Lb/a/a/b/a/g;-><init>()V

    const-string v0, "path-provider-background-%d"

    invoke-virtual {p1, v0}, Lb/a/a/b/a/g;->e(Ljava/lang/String;)Lb/a/a/b/a/g;

    const/4 v0, 0x5

    invoke-virtual {p1, v0}, Lb/a/a/b/a/g;->f(I)Lb/a/a/b/a/g;

    invoke-virtual {p1}, Lb/a/a/b/a/g;->b()Ljava/util/concurrent/ThreadFactory;

    move-result-object p1

    invoke-static {p1}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor(Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object p1

    iput-object p1, p0, Lio/flutter/plugins/b/h$d;->b:Ljava/util/concurrent/Executor;

    return-void
.end method

.method synthetic constructor <init>(Lio/flutter/plugins/b/h;Lio/flutter/plugins/b/h$a;)V
    .locals 0

    invoke-direct {p0, p1}, Lio/flutter/plugins/b/h$d;-><init>(Lio/flutter/plugins/b/h;)V

    return-void
.end method

.method private g(Ljava/util/concurrent/Callable;Lc/a/c/a/i$d;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/concurrent/Callable<",
            "TT;>;",
            "Lc/a/c/a/i$d;",
            ")V"
        }
    .end annotation

    invoke-static {}, Lb/a/a/b/a/f;->C()Lb/a/a/b/a/f;

    move-result-object v0

    new-instance v1, Lio/flutter/plugins/b/h$d$a;

    invoke-direct {v1, p0, p2}, Lio/flutter/plugins/b/h$d$a;-><init>(Lio/flutter/plugins/b/h$d;Lc/a/c/a/i$d;)V

    iget-object p2, p0, Lio/flutter/plugins/b/h$d;->a:Ljava/util/concurrent/Executor;

    invoke-static {v0, v1, p2}, Lb/a/a/b/a/c;->a(Lb/a/a/b/a/e;Lb/a/a/b/a/b;Ljava/util/concurrent/Executor;)V

    iget-object p2, p0, Lio/flutter/plugins/b/h$d;->b:Ljava/util/concurrent/Executor;

    new-instance v1, Lio/flutter/plugins/b/a;

    invoke-direct {v1, v0, p1}, Lio/flutter/plugins/b/a;-><init>(Lb/a/a/b/a/f;Ljava/util/concurrent/Callable;)V

    invoke-interface {p2, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    return-void
.end method

.method static synthetic h(Lb/a/a/b/a/f;Ljava/util/concurrent/Callable;)V
    .locals 0

    :try_start_0
    invoke-interface {p1}, Ljava/util/concurrent/Callable;->call()Ljava/lang/Object;

    move-result-object p1

    invoke-virtual {p0, p1}, Lb/a/a/b/a/f;->z(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception p1

    invoke-virtual {p0, p1}, Lb/a/a/b/a/f;->A(Ljava/lang/Throwable;)Z

    :goto_0
    return-void
.end method

.method private synthetic i()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lio/flutter/plugins/b/h$d;->c:Lio/flutter/plugins/b/h;

    invoke-static {v0}, Lio/flutter/plugins/b/h;->h(Lio/flutter/plugins/b/h;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private synthetic k()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lio/flutter/plugins/b/h$d;->c:Lio/flutter/plugins/b/h;

    invoke-static {v0}, Lio/flutter/plugins/b/h;->a(Lio/flutter/plugins/b/h;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private synthetic m()Ljava/util/List;
    .locals 1

    iget-object v0, p0, Lio/flutter/plugins/b/h$d;->c:Lio/flutter/plugins/b/h;

    invoke-static {v0}, Lio/flutter/plugins/b/h;->c(Lio/flutter/plugins/b/h;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method private synthetic o(Ljava/lang/String;)Ljava/util/List;
    .locals 1

    iget-object v0, p0, Lio/flutter/plugins/b/h$d;->c:Lio/flutter/plugins/b/h;

    invoke-static {v0, p1}, Lio/flutter/plugins/b/h;->b(Lio/flutter/plugins/b/h;Ljava/lang/String;)Ljava/util/List;

    move-result-object p1

    return-object p1
.end method

.method private synthetic q()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lio/flutter/plugins/b/h$d;->c:Lio/flutter/plugins/b/h;

    invoke-static {v0}, Lio/flutter/plugins/b/h;->e(Lio/flutter/plugins/b/h;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private synthetic s()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lio/flutter/plugins/b/h$d;->c:Lio/flutter/plugins/b/h;

    invoke-static {v0}, Lio/flutter/plugins/b/h;->i(Lio/flutter/plugins/b/h;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public a(Lc/a/c/a/i$d;)V
    .locals 1

    new-instance v0, Lio/flutter/plugins/b/g;

    invoke-direct {v0, p0}, Lio/flutter/plugins/b/g;-><init>(Lio/flutter/plugins/b/h$d;)V

    invoke-direct {p0, v0, p1}, Lio/flutter/plugins/b/h$d;->g(Ljava/util/concurrent/Callable;Lc/a/c/a/i$d;)V

    return-void
.end method

.method public b(Lc/a/c/a/i$d;)V
    .locals 1

    new-instance v0, Lio/flutter/plugins/b/c;

    invoke-direct {v0, p0}, Lio/flutter/plugins/b/c;-><init>(Lio/flutter/plugins/b/h$d;)V

    invoke-direct {p0, v0, p1}, Lio/flutter/plugins/b/h$d;->g(Ljava/util/concurrent/Callable;Lc/a/c/a/i$d;)V

    return-void
.end method

.method public c(Lc/a/c/a/i$d;)V
    .locals 1

    new-instance v0, Lio/flutter/plugins/b/d;

    invoke-direct {v0, p0}, Lio/flutter/plugins/b/d;-><init>(Lio/flutter/plugins/b/h$d;)V

    invoke-direct {p0, v0, p1}, Lio/flutter/plugins/b/h$d;->g(Ljava/util/concurrent/Callable;Lc/a/c/a/i$d;)V

    return-void
.end method

.method public d(Ljava/lang/String;Lc/a/c/a/i$d;)V
    .locals 1

    new-instance v0, Lio/flutter/plugins/b/f;

    invoke-direct {v0, p0, p1}, Lio/flutter/plugins/b/f;-><init>(Lio/flutter/plugins/b/h$d;Ljava/lang/String;)V

    invoke-direct {p0, v0, p2}, Lio/flutter/plugins/b/h$d;->g(Ljava/util/concurrent/Callable;Lc/a/c/a/i$d;)V

    return-void
.end method

.method public e(Lc/a/c/a/i$d;)V
    .locals 1

    new-instance v0, Lio/flutter/plugins/b/b;

    invoke-direct {v0, p0}, Lio/flutter/plugins/b/b;-><init>(Lio/flutter/plugins/b/h$d;)V

    invoke-direct {p0, v0, p1}, Lio/flutter/plugins/b/h$d;->g(Ljava/util/concurrent/Callable;Lc/a/c/a/i$d;)V

    return-void
.end method

.method public f(Lc/a/c/a/i$d;)V
    .locals 1

    new-instance v0, Lio/flutter/plugins/b/e;

    invoke-direct {v0, p0}, Lio/flutter/plugins/b/e;-><init>(Lio/flutter/plugins/b/h$d;)V

    invoke-direct {p0, v0, p1}, Lio/flutter/plugins/b/h$d;->g(Ljava/util/concurrent/Callable;Lc/a/c/a/i$d;)V

    return-void
.end method

.method public synthetic j()Ljava/lang/String;
    .locals 1

    invoke-direct {p0}, Lio/flutter/plugins/b/h$d;->i()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public synthetic l()Ljava/lang/String;
    .locals 1

    invoke-direct {p0}, Lio/flutter/plugins/b/h$d;->k()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public synthetic n()Ljava/util/List;
    .locals 1

    invoke-direct {p0}, Lio/flutter/plugins/b/h$d;->m()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public synthetic p(Ljava/lang/String;)Ljava/util/List;
    .locals 0

    invoke-direct {p0, p1}, Lio/flutter/plugins/b/h$d;->o(Ljava/lang/String;)Ljava/util/List;

    move-result-object p1

    return-object p1
.end method

.method public synthetic r()Ljava/lang/String;
    .locals 1

    invoke-direct {p0}, Lio/flutter/plugins/b/h$d;->q()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public synthetic t()Ljava/lang/String;
    .locals 1

    invoke-direct {p0}, Lio/flutter/plugins/b/h$d;->s()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
