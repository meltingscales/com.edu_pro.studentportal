.class abstract Lb/a/a/b/a/a$b;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lb/a/a/b/a/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x40a
    name = "b"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lb/a/a/b/a/a$a;)V
    .locals 0

    invoke-direct {p0}, Lb/a/a/b/a/a$b;-><init>()V

    return-void
.end method


# virtual methods
.method abstract a(Lb/a/a/b/a/a;Lb/a/a/b/a/a$e;Lb/a/a/b/a/a$e;)Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lb/a/a/b/a/a<",
            "*>;",
            "Lb/a/a/b/a/a$e;",
            "Lb/a/a/b/a/a$e;",
            ")Z"
        }
    .end annotation
.end method

.method abstract b(Lb/a/a/b/a/a;Ljava/lang/Object;Ljava/lang/Object;)Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lb/a/a/b/a/a<",
            "*>;",
            "Ljava/lang/Object;",
            "Ljava/lang/Object;",
            ")Z"
        }
    .end annotation
.end method

.method abstract c(Lb/a/a/b/a/a;Lb/a/a/b/a/a$l;Lb/a/a/b/a/a$l;)Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lb/a/a/b/a/a<",
            "*>;",
            "Lb/a/a/b/a/a$l;",
            "Lb/a/a/b/a/a$l;",
            ")Z"
        }
    .end annotation
.end method

.method abstract d(Lb/a/a/b/a/a$l;Lb/a/a/b/a/a$l;)V
.end method

.method abstract e(Lb/a/a/b/a/a$l;Ljava/lang/Thread;)V
.end method
