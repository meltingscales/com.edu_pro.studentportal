.class public final Lc/a/a;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lc/a/a$b;
    }
.end annotation


# static fields
.field private static d:Lc/a/a;


# instance fields
.field private a:Lio/flutter/embedding/engine/h/c;

.field private b:Lio/flutter/embedding/engine/g/a;

.field private c:Lio/flutter/embedding/engine/FlutterJNI$c;


# direct methods
.method private constructor <init>(Lio/flutter/embedding/engine/h/c;Lio/flutter/embedding/engine/g/a;Lio/flutter/embedding/engine/FlutterJNI$c;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lc/a/a;->a:Lio/flutter/embedding/engine/h/c;

    iput-object p2, p0, Lc/a/a;->b:Lio/flutter/embedding/engine/g/a;

    iput-object p3, p0, Lc/a/a;->c:Lio/flutter/embedding/engine/FlutterJNI$c;

    return-void
.end method

.method synthetic constructor <init>(Lio/flutter/embedding/engine/h/c;Lio/flutter/embedding/engine/g/a;Lio/flutter/embedding/engine/FlutterJNI$c;Lc/a/a$a;)V
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lc/a/a;-><init>(Lio/flutter/embedding/engine/h/c;Lio/flutter/embedding/engine/g/a;Lio/flutter/embedding/engine/FlutterJNI$c;)V

    return-void
.end method

.method public static d()Lc/a/a;
    .locals 1

    sget-object v0, Lc/a/a;->d:Lc/a/a;

    if-nez v0, :cond_0

    new-instance v0, Lc/a/a$b;

    invoke-direct {v0}, Lc/a/a$b;-><init>()V

    invoke-virtual {v0}, Lc/a/a$b;->a()Lc/a/a;

    move-result-object v0

    sput-object v0, Lc/a/a;->d:Lc/a/a;

    :cond_0
    sget-object v0, Lc/a/a;->d:Lc/a/a;

    return-object v0
.end method


# virtual methods
.method public a()Lio/flutter/embedding/engine/g/a;
    .locals 1

    iget-object v0, p0, Lc/a/a;->b:Lio/flutter/embedding/engine/g/a;

    return-object v0
.end method

.method public b()Lio/flutter/embedding/engine/h/c;
    .locals 1

    iget-object v0, p0, Lc/a/a;->a:Lio/flutter/embedding/engine/h/c;

    return-object v0
.end method

.method public c()Lio/flutter/embedding/engine/FlutterJNI$c;
    .locals 1

    iget-object v0, p0, Lc/a/a;->c:Lio/flutter/embedding/engine/FlutterJNI$c;

    return-object v0
.end method
