.class Lio/flutter/plugins/c/a$a$a;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/flutter/plugins/c/a$a;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Z

.field final synthetic b:Lio/flutter/plugins/c/a$a;


# direct methods
.method constructor <init>(Lio/flutter/plugins/c/a$a;Z)V
    .locals 0

    iput-object p1, p0, Lio/flutter/plugins/c/a$a$a;->b:Lio/flutter/plugins/c/a$a;

    iput-boolean p2, p0, Lio/flutter/plugins/c/a$a$a;->a:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lio/flutter/plugins/c/a$a$a;->b:Lio/flutter/plugins/c/a$a;

    iget-object v0, v0, Lio/flutter/plugins/c/a$a;->b:Lc/a/c/a/i$d;

    iget-boolean v1, p0, Lio/flutter/plugins/c/a$a$a;->a:Z

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-interface {v0, v1}, Lc/a/c/a/i$d;->b(Ljava/lang/Object;)V

    return-void
.end method
