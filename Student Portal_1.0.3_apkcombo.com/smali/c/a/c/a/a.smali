.class public final Lc/a/c/a/a;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lc/a/c/a/a$b;,
        Lc/a/c/a/a$c;,
        Lc/a/c/a/a$e;,
        Lc/a/c/a/a$d;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final a:Lc/a/c/a/b;

.field private final b:Ljava/lang/String;

.field private final c:Lc/a/c/a/g;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lc/a/c/a/g<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lc/a/c/a/b;Ljava/lang/String;Lc/a/c/a/g;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lc/a/c/a/b;",
            "Ljava/lang/String;",
            "Lc/a/c/a/g<",
            "TT;>;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lc/a/c/a/a;->a:Lc/a/c/a/b;

    iput-object p2, p0, Lc/a/c/a/a;->b:Ljava/lang/String;

    iput-object p3, p0, Lc/a/c/a/a;->c:Lc/a/c/a/g;

    return-void
.end method

.method static synthetic a(Lc/a/c/a/a;)Lc/a/c/a/g;
    .locals 0

    iget-object p0, p0, Lc/a/c/a/a;->c:Lc/a/c/a/g;

    return-object p0
.end method

.method static synthetic b(Lc/a/c/a/a;)Ljava/lang/String;
    .locals 0

    iget-object p0, p0, Lc/a/c/a/a;->b:Ljava/lang/String;

    return-object p0
.end method


# virtual methods
.method public c(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lc/a/c/a/a;->d(Ljava/lang/Object;Lc/a/c/a/a$e;)V

    return-void
.end method

.method public d(Ljava/lang/Object;Lc/a/c/a/a$e;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Lc/a/c/a/a$e<",
            "TT;>;)V"
        }
    .end annotation

    iget-object v0, p0, Lc/a/c/a/a;->a:Lc/a/c/a/b;

    iget-object v1, p0, Lc/a/c/a/a;->b:Ljava/lang/String;

    iget-object v2, p0, Lc/a/c/a/a;->c:Lc/a/c/a/g;

    invoke-interface {v2, p1}, Lc/a/c/a/g;->b(Ljava/lang/Object;)Ljava/nio/ByteBuffer;

    move-result-object p1

    const/4 v2, 0x0

    if-nez p2, :cond_0

    goto :goto_0

    :cond_0
    new-instance v3, Lc/a/c/a/a$c;

    invoke-direct {v3, p0, p2, v2}, Lc/a/c/a/a$c;-><init>(Lc/a/c/a/a;Lc/a/c/a/a$e;Lc/a/c/a/a$a;)V

    move-object v2, v3

    :goto_0
    invoke-interface {v0, v1, p1, v2}, Lc/a/c/a/b;->a(Ljava/lang/String;Ljava/nio/ByteBuffer;Lc/a/c/a/b$b;)V

    return-void
.end method

.method public e(Lc/a/c/a/a$d;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lc/a/c/a/a$d<",
            "TT;>;)V"
        }
    .end annotation

    iget-object v0, p0, Lc/a/c/a/a;->a:Lc/a/c/a/b;

    iget-object v1, p0, Lc/a/c/a/a;->b:Ljava/lang/String;

    const/4 v2, 0x0

    if-nez p1, :cond_0

    goto :goto_0

    :cond_0
    new-instance v3, Lc/a/c/a/a$b;

    invoke-direct {v3, p0, p1, v2}, Lc/a/c/a/a$b;-><init>(Lc/a/c/a/a;Lc/a/c/a/a$d;Lc/a/c/a/a$a;)V

    move-object v2, v3

    :goto_0
    invoke-interface {v0, v1, v2}, Lc/a/c/a/b;->c(Ljava/lang/String;Lc/a/c/a/b$a;)V

    return-void
.end method
