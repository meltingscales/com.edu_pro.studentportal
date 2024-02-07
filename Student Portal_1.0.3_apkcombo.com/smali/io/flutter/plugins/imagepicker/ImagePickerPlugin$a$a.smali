.class Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a$a;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;->b(Ljava/lang/Object;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/Object;

.field final synthetic b:Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;


# direct methods
.method constructor <init>(Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;Ljava/lang/Object;)V
    .locals 0

    iput-object p1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a$a;->b:Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;

    iput-object p2, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a$a;->a:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a$a;->b:Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;

    invoke-static {v0}, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;->d(Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;)Lc/a/c/a/i$d;

    move-result-object v0

    iget-object v1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a$a;->a:Ljava/lang/Object;

    invoke-interface {v0, v1}, Lc/a/c/a/i$d;->b(Ljava/lang/Object;)V

    return-void
.end method
