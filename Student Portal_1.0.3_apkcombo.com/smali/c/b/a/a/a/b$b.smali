.class final Lc/b/a/a/a/b$b;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lc/b/a/a/a/b;->b()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation


# instance fields
.field final synthetic a:Lc/b/a/a/a/b;


# direct methods
.method constructor <init>(Lc/b/a/a/a/b;)V
    .locals 0

    iput-object p1, p0, Lc/b/a/a/a/b$b;->a:Lc/b/a/a/a/b;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    iget-object v0, p0, Lc/b/a/a/a/b$b;->a:Lc/b/a/a/a/b;

    invoke-virtual {v0}, Lc/b/a/a/a/b;->b()V

    return-void
.end method
