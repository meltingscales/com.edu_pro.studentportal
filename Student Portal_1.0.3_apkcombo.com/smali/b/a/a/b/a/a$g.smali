.class final Lb/a/a/b/a/a$g;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lb/a/a/b/a/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "g"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/lang/Runnable;"
    }
.end annotation


# instance fields
.field final a:Lb/a/a/b/a/a;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lb/a/a/b/a/a<",
            "TV;>;"
        }
    .end annotation
.end field

.field final b:Lb/a/a/b/a/e;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lb/a/a/b/a/e<",
            "+TV;>;"
        }
    .end annotation
.end field


# virtual methods
.method public run()V
    .locals 3

    iget-object v0, p0, Lb/a/a/b/a/a$g;->a:Lb/a/a/b/a/a;

    invoke-static {v0}, Lb/a/a/b/a/a;->e(Lb/a/a/b/a/a;)Ljava/lang/Object;

    move-result-object v0

    if-eq v0, p0, :cond_0

    return-void

    :cond_0
    iget-object v0, p0, Lb/a/a/b/a/a$g;->b:Lb/a/a/b/a/e;

    invoke-static {v0}, Lb/a/a/b/a/a;->g(Lb/a/a/b/a/e;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {}, Lb/a/a/b/a/a;->c()Lb/a/a/b/a/a$b;

    move-result-object v1

    iget-object v2, p0, Lb/a/a/b/a/a$g;->a:Lb/a/a/b/a/a;

    invoke-virtual {v1, v2, p0, v0}, Lb/a/a/b/a/a$b;->b(Lb/a/a/b/a/a;Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lb/a/a/b/a/a$g;->a:Lb/a/a/b/a/a;

    invoke-static {v0}, Lb/a/a/b/a/a;->h(Lb/a/a/b/a/a;)V

    :cond_1
    return-void
.end method
