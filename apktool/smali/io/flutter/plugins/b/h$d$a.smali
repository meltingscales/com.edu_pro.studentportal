.class Lio/flutter/plugins/b/h$d$a;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Lb/a/a/b/a/b;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/flutter/plugins/b/h$d;->g(Ljava/util/concurrent/Callable;Lc/a/c/a/i$d;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lb/a/a/b/a/b<",
        "TT;>;"
    }
.end annotation


# instance fields
.field final synthetic a:Lc/a/c/a/i$d;


# direct methods
.method constructor <init>(Lio/flutter/plugins/b/h$d;Lc/a/c/a/i$d;)V
    .locals 0

    iput-object p2, p0, Lio/flutter/plugins/b/h$d$a;->a:Lc/a/c/a/i$d;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/Throwable;)V
    .locals 3

    iget-object v0, p0, Lio/flutter/plugins/b/h$d$a;->a:Lc/a/c/a/i$d;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p1

    const/4 v2, 0x0

    invoke-interface {v0, v1, p1, v2}, Lc/a/c/a/i$d;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method public b(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lio/flutter/plugins/b/h$d$a;->a:Lc/a/c/a/i$d;

    invoke-interface {v0, p1}, Lc/a/c/a/i$d;->b(Ljava/lang/Object;)V

    return-void
.end method
