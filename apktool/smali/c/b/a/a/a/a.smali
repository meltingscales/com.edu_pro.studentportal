.class public final Lc/b/a/a/a/a;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Lio/flutter/embedding/engine/i/a;


# instance fields
.field private a:Lc/a/c/a/i;


# direct methods
.method static constructor <clinit>()V
    .locals 0

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private final b()V
    .locals 2

    iget-object v0, p0, Lc/b/a/a/a/a;->a:Lc/a/c/a/i;

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    invoke-virtual {v0, v1}, Lc/a/c/a/i;->e(Lc/a/c/a/i$c;)V

    :cond_0
    iput-object v1, p0, Lc/b/a/a/a/a;->a:Lc/a/c/a/i;

    return-void
.end method


# virtual methods
.method public final a(Lc/a/c/a/b;Landroid/content/Context;)V
    .locals 2

    const-string v0, "messenger"

    invoke-static {p1, v0}, Ld/d/a/a;->c(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "context"

    invoke-static {p2, v0}, Ld/d/a/a;->c(Ljava/lang/Object;Ljava/lang/String;)V

    new-instance v0, Lc/a/c/a/i;

    const-string v1, "PonnamKarthik/fluttertoast"

    invoke-direct {v0, p1, v1}, Lc/a/c/a/i;-><init>(Lc/a/c/a/b;Ljava/lang/String;)V

    iput-object v0, p0, Lc/b/a/a/a/a;->a:Lc/a/c/a/i;

    new-instance p1, Lc/b/a/a/a/b;

    invoke-direct {p1, p2}, Lc/b/a/a/a/b;-><init>(Landroid/content/Context;)V

    iget-object p2, p0, Lc/b/a/a/a/a;->a:Lc/a/c/a/i;

    if-eqz p2, :cond_0

    invoke-virtual {p2, p1}, Lc/a/c/a/i;->e(Lc/a/c/a/i$c;)V

    :cond_0
    return-void
.end method

.method public d(Lio/flutter/embedding/engine/i/a$b;)V
    .locals 1

    const-string v0, "p0"

    invoke-static {p1, v0}, Ld/d/a/a;->c(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0}, Lc/b/a/a/a/a;->b()V

    return-void
.end method

.method public g(Lio/flutter/embedding/engine/i/a$b;)V
    .locals 2

    const-string v0, "binding"

    invoke-static {p1, v0}, Ld/d/a/a;->c(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1}, Lio/flutter/embedding/engine/i/a$b;->b()Lc/a/c/a/b;

    move-result-object v0

    const-string v1, "binding.binaryMessenger"

    invoke-static {v0, v1}, Ld/d/a/a;->b(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p1}, Lio/flutter/embedding/engine/i/a$b;->a()Landroid/content/Context;

    move-result-object p1

    const-string v1, "binding.applicationContext"

    invoke-static {p1, v1}, Ld/d/a/a;->b(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {p0, v0, p1}, Lc/b/a/a/a/a;->a(Lc/a/c/a/b;Landroid/content/Context;)V

    return-void
.end method
