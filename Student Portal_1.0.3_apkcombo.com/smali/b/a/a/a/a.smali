.class public final Lb/a/a/a/a;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lb/a/a/a/a$b;
    }
.end annotation


# direct methods
.method public static a(Ljava/lang/Object;)Lb/a/a/a/a$b;
    .locals 2

    new-instance v0, Lb/a/a/a/a$b;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object p0

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lb/a/a/a/a$b;-><init>(Ljava/lang/String;Lb/a/a/a/a$a;)V

    return-object v0
.end method
